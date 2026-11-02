package Persistencia;

import Entidades.Asistencia;
import Entidades.Clase;
import Entidades.Pase;
import Entidades.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AsistenciaData {

    private Connection conexion;
    private SocioData socioData;
    private ClaseData claseData;
    private PaseData paseData;

    // Constructor
    public AsistenciaData() {
        conexion = Conexion.getConexion();
        socioData = new SocioData();
        claseData = new ClaseData();
        paseData = new PaseData();
    }

    // Validar socio
    private boolean validarSocio(Asistencia a) {

        if (a.getSocio() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un socio");
            return false;
        }

        Socio s = socioData.buscarSocioPorId(
                a.getSocio().getIdSocio());

        if (s == null) {
            JOptionPane.showMessageDialog(null, "El socio no existe o está inactivo");
            return false;
        }

        return true;
    }

    // Validar clase
    private boolean validarClase(Asistencia a) {

        if (a.getClase() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una clase");
            return false;
        }

        Clase c = claseData.buscarClasePorId(
                a.getClase().getIdClase());

        if (c == null) {
            JOptionPane.showMessageDialog(null, "La clase no existe o está inactiva");
            return false;
        }

        return true;
    }

    // Validar pase activo del socio
    private boolean validarPase(Asistencia a) {

        Pase paseActivo = paseData.obtenerPaseActivoPorSocio(
                a.getSocio().getIdSocio());

        if (paseActivo == null) {
            JOptionPane.showMessageDialog(null,
                    "El socio no posee un pase activo vigente o no le quedan entradas");
            return false;
        }

        // Comprobar fecha de inicio
        if (paseActivo.getFechaInicio().isAfter(
                java.time.LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "El pase todavía no está vigente");
            return false;
        }

        // Comprobar fecha de vencimiento
        if (paseActivo.getFechaFin().isBefore(
                java.time.LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "El pase está vencido");
            return false;
        }

        // Asignar el pase a la asistencia
        a.setPase(paseActivo);

        return true;
    }

    // Validar capacidad de la clase
    private boolean validarCapacidad(Asistencia a) {

        String sql = "SELECT COUNT(*) FROM asistencias "
                + "WHERE ID_Clase = ? AND Fecha_Asistencia = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, a.getClase().getIdClase());
            ps.setDate(2, Date.valueOf(a.getFechaAsistencia()));

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    int cantidad = rs.getInt(1);

                    if (cantidad >= a.getClase().getCapacidad()) {
                        JOptionPane.showMessageDialog(null,
                                "La clase alcanzó su capacidad máxima");
                        return false;
                    }
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al validar capacidad: " + ex.getMessage());
            return false;
        }

        return true;
    }

    // Validar asistencia duplicada
    private boolean validarDuplicado(Asistencia a) {

        String sql = "SELECT COUNT(*) FROM asistencias "
                + "WHERE ID_Socio = ? AND ID_Clase = ? AND Fecha_Asistencia = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, a.getSocio().getIdSocio());
            ps.setInt(2, a.getClase().getIdClase());
            ps.setDate(3, Date.valueOf(a.getFechaAsistencia()));

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null,
                            "El socio ya tiene registrada una asistencia para esta clase y fecha");
                    return false;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al validar asistencia: " + ex.getMessage());
            return false;
        }

        return true;
    }

    // Validar asistencia
    private boolean validarAsistencia(Asistencia a) {

        if (a == null) {
            JOptionPane.showMessageDialog(null, "La asistencia no puede ser nula");
            return false;
        }

        if (a.getFechaAsistencia() == null) {
            JOptionPane.showMessageDialog(null, "Debe indicar la fecha de asistencia");
            return false;
        }

        if (!validarSocio(a)) {
            return false;
        }
        if (!validarClase(a)) {
            return false;
        }
        if (!validarPase(a)) {
            return false;
        }
        if (!validarCapacidad(a)) {
            return false;
        }
        if (!validarDuplicado(a)) {
            return false;
        }

        return true;
    }

    // Registrar asistencia
    public void registrarAsistencia(Asistencia a) {

        // Realizar validaciones
        if (!validarAsistencia(a)) {
            return;
        }

        String sql = "INSERT INTO asistencias (ID_Socio, ID_Clase, ID_Pase, Fecha_Asistencia) "
                + "VALUES (?, ?, ?, ?)";

        boolean autoCommitAnterior = true;

        try {

            // Guardar el estado original
            autoCommitAnterior = conexion.getAutoCommit();

            // Iniciar transacción
            conexion.setAutoCommit(false);

            // Insertar asistencia
            try (PreparedStatement ps = conexion.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, a.getSocio().getIdSocio());
                ps.setInt(2, a.getClase().getIdClase());
                ps.setInt(3, a.getPase().getIdPase());
                ps.setDate(4, Date.valueOf(a.getFechaAsistencia()));

                ps.executeUpdate();

                // Recuperar ID generado
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        a.setIdAsistencia(rs.getInt(1));
                    }
                }
            }

            // Descontar una entrada del pase
            boolean descontado = paseData.descontarEntrada(
                    conexion, a.getPase().getIdPase());

            if (!descontado) {
                throw new SQLException("No se pudo descontar la entrada del pase");
            }

            // Confirmar las operaciones
            conexion.commit();

            JOptionPane.showMessageDialog(null,
                    "Asistencia registrada correctamente.\n"
                    + "ID: " + a.getIdAsistencia()
                    + "\nPase: " + a.getPase().getIdPase()
                    + "\nEntrada descontada correctamente.");

        } catch (SQLException ex) {

            try {
                conexion.rollback();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, "Error al deshacer la operación: " + error.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Error al registrar asistencia: " + ex.getMessage());

        } finally {

            try {
                conexion.setAutoCommit(autoCommitAnterior);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al restaurar la conexión: " + ex.getMessage());
            }
        }
    }

    //LISTAR ASISTENCIA
    public List<Asistencia> listarAsistencia() {
        List<Asistencia> lista = new ArrayList<>();

        String sql = "SELECT * FROM asistencias";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Asistencia a = new Asistencia();

                a.setIdAsistencia(rs.getInt("ID_Asistencia"));

                // Recuperar socio
                int idSocio = rs.getInt("ID_Socio");
                Socio socio = socioData.buscarSocioPorId(idSocio);
                a.setSocio(socio);

                // Recuperar clase
                int idClase = rs.getInt("ID_Clase");
                Clase clase = claseData.buscarClasePorId(idClase);
                a.setClase(clase);

                // Recuperar pase
                int idPase = rs.getInt("ID_Pase");
                Pase pase = paseData.buscarPasePorId(idPase);
                a.setPase(pase);

                // Recuperar fecha
                a.setFechaAsistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
                lista.add(a);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al listar asistencias: " + ex.getMessage());
        }

        return lista;
    }
    
    //BUSCAR ASISTENCIA
    public Asistencia buscarAsistenciaPorId(int id) {
        Asistencia a = null;
        String sql = "SELECT * FROM asistencias WHERE ID_Asistencia = ?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                a = new Asistencia();
                a.setIdAsistencia(rs.getInt("ID_Asistencia"));
                //recuperar socio
                int idSocio = rs.getInt("ID_Socio");
                Socio socio = socioData.buscarSocioPorId(idSocio);
                a.setSocio(socio);
                //recuperar Clase
                int idClase = rs.getInt("ID_Clase");
                Clase clase = claseData.buscarClasePorId(idClase);
                a.setClase(clase);
                //recuperar pase
                int idPase = rs.getInt("ID_Pase");
                Pase pase = paseData.buscarPasePorId(idPase);
                a.setPase(pase);
                a.setFechaAsistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al buscar asistencia " + ex.getMessage());
        }
        return a;
    }
    
    //
    
}

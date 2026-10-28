package Persistencia;

import Entidades.Clase;
import Entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClaseData {

    private Connection conexion;
    private EntrenadorData entrenadorData;

    //constructor
    public ClaseData() {
        conexion = Conexion.getConexion();
        entrenadorData = new EntrenadorData();
    }

    //METODO DE VALIDACIONES. si no entra en ningun if retorna true y puede continuar compilando
    private boolean validarClase(Clase c) {
        //clase no sea null y exista
        if (c == null) {
            JOptionPane.showMessageDialog(null, "La clase no puede ser nula.");
            return false;
        }

        //disciplina no este vacia
        if (c.getDisciplina() == null || c.getDisciplina().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una disciplina.");
            return false;
        }

        //la capacidad sea entre 1 y 30
        if (c.getCapacidad() < 1 || c.getCapacidad() > 30) {
            JOptionPane.showMessageDialog(null, "La capacidad debe estar entre 1 y 30 personas.");
            return false;
        }

        //no este seleccionado entrenador
        if (c.getEntrenador() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un entrenador.");
            return false;
        }

        //el entrenador tenga el id ingresado valido
        if (c.getEntrenador().getIdEntrenador() <= 0) {
            JOptionPane.showMessageDialog(null,"El entrenador seleccionado no es válido.");
            return false;
        }

        return true;
    }

    //GUARDAR CLASE
    public void guardarClase(Clase c) {
        //valido la clase con mi metodo 
        
        
        String sql = "INSERT INTO clases (Disciplina, ID_Entrenador, Horario, Capacidad, Estado) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getDisciplina());
            ps.setInt(2, c.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(c.getHorario())); //convertimos la hra para enviarlo a la BD
            ps.setInt(4, c.getCapacidad());
            ps.setBoolean(5, c.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                c.setIdClase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase creada con éxito. ID: " + c.getIdClase());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la clase: " + ex.getMessage());
        }
    }

    //BUSCAR POR ID
    public Clase buscarClasePorId(int id) {
        Clase c = null;
        String sql = "SELECT * FROM clases WHERE ID_Clase = ? AND Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Clase();
                c.setIdClase(rs.getInt("ID_Clase"));
                c.setDisciplina(rs.getString("Disciplina"));
                //creo una variable para buscar en la BD y obtener el ID
                //del entrenador con rs.getInt d la tabla clases
                int idEntrenador = rs.getInt("ID_Entrenador");
                //con ese id puedo buscar y obtener el objeto Entrenador y guardarlo en la variable
                Entrenador e = entrenadorData.buscarPorId(idEntrenador);
                //guardo el objeto entrenador dentro del objeto clase
                c.setEntrenador(e);
                //convierto el formato de la hora que devuelve la BD en LocalTime de java
                c.setHorario(rs.getTime("Horario").toLocalTime());
                c.setCapacidad(rs.getInt("Capacidad"));
                c.setEstado(rs.getBoolean("Estado"));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la clase: " + ex.getMessage());
        }
        return c;
    }

    //LISTAR CLASES ACTIVAS 
    public List<Clase> listarClases() {
        List<Clase> lista = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase c = new Clase();
                c.setIdClase(rs.getInt("ID_Clase"));
                c.setDisciplina(rs.getString("Disciplina"));
                //Misma logica que el metodo anterior
                int idEntrenador = rs.getInt("ID_Entrenador");
                Entrenador en = entrenadorData.buscarPorId(idEntrenador);
                c.setEntrenador(en);
                //con la hora tambien lo mismo del metodo anterior
                c.setHorario(rs.getTime("Horario").toLocalTime());
                c.setCapacidad(rs.getInt("Capacidad"));
                c.setEstado(rs.getBoolean("Estado"));
                //guardo la clase con los datos obtenidos de la BD en la lista
                lista.add(c);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las clases: " + ex.getMessage());
        }
        return lista;
    }

    //MODIFICAR clase
    public void modificarClase(Clase c) {
        String sql = "UPDATE clases SET Disciplina = ?, ID_Entrenador = ?, Horario = ?, Capacidad = ?, Estado = ? WHERE ID_Clase = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, c.getDisciplina());
            ps.setInt(2, c.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(c.getHorario()));
            ps.setInt(4, c.getCapacidad());
            ps.setBoolean(5, c.isEstado());
            ps.setInt(6, c.getIdClase());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Clase modificada correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la clase: " + ex.getMessage());
        }
    }

    //BAJA LOGICA por id
    public void bajaClase(int id) {
        String sql = "UPDATE clases SET Estado = 0 WHERE ID_Clase = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Clase dada de baja correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja la clase: " + ex.getMessage());
        }
    }

}

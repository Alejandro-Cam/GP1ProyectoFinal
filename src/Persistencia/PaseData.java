package Persistencia;

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

public class PaseData {

    private Connection conexion;
    private SocioData socioData;

    //constructor
    public PaseData() {
        conexion = Conexion.getConexion();
        socioData = new SocioData();
    }

    //VALIDACIONES
    private boolean validarPase(Pase p) {
        //pase que no sea null
        if (p == null) {
            JOptionPane.showMessageDialog(null, "El pase no debe ser nulo");
            return false;
        }

        //socio no null
        if (p.getSocio() == null) {
            JOptionPane.showMessageDialog(null, "El socio no debe ser nulo");
            return false;
        }

        Socio socioEncontrado = socioData.buscarSocioPorId(p.getSocio().getIdSocio());

        if (socioEncontrado == null) {
            JOptionPane.showMessageDialog(null, "El socio no existe o está inactivo");
            return false;
        }

        //cantidad de entradas mayores que cero
        if (p.getCantidadEntradas() <= 0) {
            JOptionPane.showMessageDialog(null, "El numero de entradas debe ser mayor que cero");
            return false;
        }

        //fecha no null
        if (p.getFechaInicio() == null) {
            JOptionPane.showMessageDialog(null, "la fecha no debe ser nula");
            return false;
        }

        if (p.getCosto() < 0) {
            JOptionPane.showMessageDialog(null, "El costo debe ser mayor a cero");
            return false;
        }

        //fecha de fin correcta
        if (!p.getFechaInicio().plusDays(30).equals(p.getFechaFin())) {
            JOptionPane.showMessageDialog(null, "La fecha de fin es incorrecta");
            return false;
        }

        return true;
    }

    //GUARDAR
    public void guardarPase(Pase p) {
        //VALIDACIONES
        if (!validarPase(p)) {
            return;
        }

        String sql = "INSERT INTO pases (ID_Socio, CantidadEntradas, Fecha_Inicio, Fecha_Fin, Costo, Estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getSocio().getIdSocio());
            ps.setInt(2, p.getCantidadEntradas());
            ps.setDate(3, Date.valueOf(p.getFechaInicio()));
            ps.setDate(4, Date.valueOf(p.getFechaFin()));
            ps.setDouble(5, p.getCosto());
            ps.setBoolean(6, p.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                p.setIdPase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pase registrado con éxito. ID: " + p.getIdPase());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el pase: " + ex.getMessage());
        }
    }

    //BUSCAR PASE POR ID
    public Pase buscarPasePorId(int id) {
        Pase p = null;
        String sql = "SELECT * FROM pases WHERE ID_Pase = ? AND Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Pase();
                p.setIdPase(rs.getInt("ID_Pase"));

                // Recuperar el socio titular del pase
                int idSocio = rs.getInt("ID_Socio");
                Socio socio = socioData.buscarSocioPorId(idSocio);
                p.setSocio(socio);

                p.setCantidadEntradas(rs.getInt("CantidadEntradas"));
                p.setFechaInicio(rs.getDate("Fecha_Inicio").toLocalDate());
                p.setFechaFin(rs.getDate("Fecha_Fin").toLocalDate());
                p.setCosto(rs.getDouble("Costo"));
                p.setEstado(rs.getBoolean("Estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pase: " + ex.getMessage());
        }
        return p;
    }

    //OBTENER PASE ACTIVO VIGENTE DE UN SOCIO
    public Pase obtenerPaseActivoPorSocio(int idSocio) {
        Pase p = null;
        String sql = "SELECT * FROM pases WHERE ID_Socio = ? AND Estado = 1 AND Fecha_Fin >= CURDATE() AND CantidadEntradas > 0 ORDER BY ID_Pase DESC LIMIT 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Pase();
                p.setIdPase(rs.getInt("ID_Pase"));

                Socio socio = socioData.buscarSocioPorId(idSocio);
                p.setSocio(socio);

                p.setCantidadEntradas(rs.getInt("CantidadEntradas"));
                p.setFechaInicio(rs.getDate("Fecha_Inicio").toLocalDate());
                p.setFechaFin(rs.getDate("Fecha_Fin").toLocalDate());
                p.setCosto(rs.getDouble("Costo"));
                p.setEstado(rs.getBoolean("Estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el pase activo: " + ex.getMessage());
        }
        return p;
    }

    //LISTAR PASES
    public List<Pase> listarPases() {
        List<Pase> lista = new ArrayList<>();
        String sql = "SELECT * FROM pases WHERE Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pase p = new Pase();
                p.setIdPase(rs.getInt("ID_Pase"));

                // Recuperar el socio titular del pase
                int idSocio = rs.getInt("ID_Socio");
                Socio socio = socioData.buscarSocioPorId(idSocio);
                p.setSocio(socio);

                p.setCantidadEntradas(rs.getInt("CantidadEntradas"));
                p.setFechaInicio(rs.getDate("Fecha_Inicio").toLocalDate());
                p.setFechaFin(rs.getDate("Fecha_Fin").toLocalDate());
                p.setCosto(rs.getDouble("Costo"));
                p.setEstado(rs.getBoolean("Estado"));
                lista.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los pases: " + ex.getMessage());
        }
        return lista;
    }

    //MODIFICAR PASE
    public void modificarPase(Pase p) {
        //validaciones
        if (!validarPase(p)) {
            return;
        }
        if (p.getIdPase() <= 0) {
            JOptionPane.showMessageDialog(null, "El ID del pase no es válido");
            return;
        }
        
        String sql = "UPDATE pases SET ID_Socio = ?, CantidadEntradas = ?, Fecha_Inicio = ?, Fecha_Fin = ?, Costo = ?, Estado = ? WHERE ID_Pase = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, p.getSocio().getIdSocio());
            ps.setInt(2, p.getCantidadEntradas());
            ps.setDate(3, Date.valueOf(p.getFechaInicio()));
            ps.setDate(4, Date.valueOf(p.getFechaFin()));
            ps.setDouble(5, p.getCosto());
            ps.setBoolean(6, p.isEstado());
            ps.setInt(7, p.getIdPase());
            //comprobar cambios
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Pase modificado exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la pase: " + ex.getMessage());
        }
    }

    //DESCONTAR 1 ENTRADA AL PASE
    public void descontarEntrada(int idPase) {
        String sql = "UPDATE pases SET CantidadEntradas = CantidadEntradas - 1 WHERE ID_Pase = ? AND CantidadEntradas > 0";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPase);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al descontar entrada del pase: " + ex.getMessage());
        }
    }

    //BAJA LÓGICA
    public void bajaPase(int id) {
        String sql = "UPDATE pases SET Estado = 0 WHERE ID_Pase = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Pase dado de baja correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el pase: " + ex.getMessage());
        }
    }

    public void altaPase(int id) {
        String sql = "UPDATE pases SET Estado = 1 WHERE ID_Pase = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Pase dado de alta correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el pase: " + ex.getMessage());
        }
    }
}

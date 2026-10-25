package Persistencia;

import Entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SocioData {

    private Connection conexion;

    //constructor
    public SocioData() {
        conexion = Conexion.getConexion();
    }

    //INSERT
    public void guardarSocio(Socio s) {
        String sql = "INSERT INTO `socios`(`DNI`, `Nombre`, `Apellido`, `Edad`, `Correo`, `Telefono`, `Estado`) "
                + "VALUES (? , ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellido());
            ps.setInt(4, s.getEdad());
            ps.setString(5, s.getCorreo());
            ps.setString(6, s.getTelefono());
            ps.setBoolean(7, s.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                s.setIdSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Socio guardado con éxito. ID: " + s.getIdSocio());
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar socio: " + ex.getMessage());
        }
    }

    //SELECT listar socios activos
    public List<Socio> listarSocio() {
        List<Socio> socios = new ArrayList<>();
        String sql = "SELECT * FROM socios WHERE estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Socio s = new Socio(
                        rs.getInt("id_Socio"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getBoolean("estado")
                );
                socios.add(s);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar socios: " + ex.getMessage());
        }
        return socios;
    }

    //CONSULTA, busqueda por dni
    public Socio buscarSocioPorDni(String dni) {
        Socio s = null;

        String sql = "SELECT * FROM socios WHERE DNI = ? AND Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Socio();
                s.setIdSocio(rs.getInt("ID_Socio"));
                s.setDni(rs.getString("DNI"));
                s.setNombre(rs.getString("Nombre"));
                s.setApellido(rs.getString("Apellido"));
                s.setEdad(rs.getInt("Edad"));
                s.setCorreo(rs.getString("Correo"));
                s.setTelefono(rs.getString("Telefono"));
                s.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun socio activo con DNI: " + dni);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar socio por DNI: " + ex.getMessage());
        }
        return s;
    }

    //UPDATE modificar socio
    public void modificarSocio(Socio s) {
        String sql = "UPDATE socios SET DNI = ?, Nombre = ?, Apellido = ?, Edad = ?, Correo = ?, Telefono = ?, Estado = ? WHERE ID_Socio = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellido());
            ps.setInt(4, s.getEdad());
            ps.setString(5, s.getCorreo());
            ps.setString(6, s.getTelefono());
            ps.setBoolean(7, s.isEstado());
            ps.setInt(8, s.getIdSocio());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Socio modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar. El socio no existe.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar socio: " + ex.getMessage());
        }
    }

    //BAJA LOGICA, UPDATE estado = 0
    public void bajaLogica(int id) {
        String sql = "UPDATE socios SET Estado = 0 WHERE ID_Socio = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Socio dado de baja con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el socio: " + ex.getMessage());
        }
    }

    //ALTA LOGICA
    public void altaLogica(int id) {
        String sql = "UPDATE socios SET Estado = 1 WHERE ID_Socio = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Socio dado de alta con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el socio: " + ex.getMessage());
        }
    }
}

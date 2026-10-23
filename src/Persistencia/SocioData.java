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
    

}

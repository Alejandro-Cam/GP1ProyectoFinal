package Persistencia;

import Entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

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
                s.setIdSocios(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Socio guardado con éxito. ID: " + s.getIdSocios());
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar socio: " + ex.getMessage());
        }
    }

}

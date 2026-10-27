package Persistencia;

import Entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EntrenadorData {

    private Connection conexion;

    //constructor
    public EntrenadorData() {
        conexion = Conexion.getConexion();
    }

    //INSERT guardar entrenador
    public void guardarEntrenador(Entrenador e) {
        String sql = "INSERT INTO entrenadores (DNI, Nombre, Apellido, Especialidad, Estado) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            ps.setString(4, e.getEspecialidad());
            ps.setBoolean(5, e.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entrenador guardado con éxito. ID: " + e.getIdEntrenador());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar entrenador: " + ex.getMessage());
        }
    }

    //SELECT buscar por id
    public Entrenador buscarPorId(int id) {
        Entrenador e = null;
        String sql = "SELECT * FROM entrenadores WHERE ID_Entrenador = ? AND Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Entrenador();
                e.setIdEntrenador(rs.getInt("ID_Entrenador"));
                e.setDni(rs.getString("DNI"));
                e.setNombre(rs.getString("Nombre"));
                e.setApellido(rs.getString("Apellido"));
                e.setEspecialidad(rs.getString("Especialidad"));
                e.setEstado(rs.getBoolean("Estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar entrenador: " + ex.getMessage());
        }
        return e;
    }

    //LISTA DE ENTRENADORES ACTIVOS 
    public List<Entrenador> listarEntrenadores() {
        List<Entrenador> entrenadores = new ArrayList<>();
        String sql = "SELECT * FROM entrenadores WHERE Estado = 1";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Entrenador e = new Entrenador(
                        rs.getInt("ID_Entrenador"),
                        rs.getString("DNI"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Especialidad"),
                        rs.getBoolean("Estado")
                );
                entrenadores.add(e);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar entrenadores: " + ex.getMessage());
        }
        return entrenadores;
    }

    //MODIFICAR 
    public void modificarEntrenador(Entrenador e) {
        String sql = "UPDATE entrenadores SET DNI = ?, Nombre = ?, Apellido = ?, Especialidad = ?, Estado = ? WHERE ID_Entrenador = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            ps.setString(4, e.getEspecialidad());
            ps.setBoolean(5, e.isEstado());
            ps.setInt(6, e.getIdEntrenador());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Entrenador modificado correctamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar entrenador: " + ex.getMessage());
        }
    }

    //BAJA LOGICA
    public void bajaEntrenador(int id) {
        String sql = "UPDATE entrenadores SET Estado = 0 WHERE ID_Entrenador = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Entrenador dado de baja correctamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja al entrenador: " + ex.getMessage());
        }
    }
    
    //Alta logica
    public void AltaEntrenador(int id) {
        String sql = "UPDATE entrenadores SET Estado = 1 WHERE ID_Entrenador = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Entrenador dado de alta correctamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta al entrenador: " + ex.getMessage());
        }
    }
}

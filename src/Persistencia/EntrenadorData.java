package Persistencia;

import Entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        
        try{
        PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, e.getDni());
        ps.setString(2, e.getNombre());
        ps.setString(3, e.getApellido());
        ps.setString(4, e.getEspecialidad());
        ps.setBoolean(5, e.isEstado());
        
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if(rs.next()) {
            JOptionPane.showMessageDialog(null, "Entrenador guardado con éxito. ID: " + e.getIdEntrenador());
        }
        ps.close();
        
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar entrenador: " + ex.getMessage());
        }
    }
    
    //
    
}

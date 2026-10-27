package Persistencia;

import Entidades.Clase;
import Entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

public class ClaseData {

    private Connection conexion;
    private EntrenadorData entrenadorData;

    //constructor
    public ClaseData() {
        conexion = Conexion.getConexion();
        entrenadorData = new EntrenadorData();
    }

    //GUARDAR CLASE
    public void guardarClase(Clase c) {
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
    public Clase buscarClasePorId (int id) {
        Clase c = null;
        String sql = "SELECT * FROM clases WHERE ID_Clase = ? AND Estado = 1";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
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
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la clase: " + ex.getMessage());
        }
        return c;
    }
    
    
    
    
}

package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    //Atributos para la conexiona a base de datos
    private static final String url = "jdbc:mariadb://localhost:3306/aborigym";
    private static final String usuario = "root";
    private static final String password = "";
    private static Connection conexion = null;
    
    //constructor vacio
    public Conexion(){};
    
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                // Carga del driver MariaDB según la Guía 4
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el driver MariaDB: " + e.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la BD: " + e.getMessage());
            }
        }
        return conexion;
    }
}

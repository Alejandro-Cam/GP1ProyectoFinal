package Persistencia;

import Entidades.Asistencia;
import Entidades.Pase;
import Entidades.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AsistenciaData {

    private Connection conexion;
    private SocioData socioData;
    private ClaseData claseData;
    private PaseData paseData;

    //constructor
    public AsistenciaData() {
        conexion = Conexion.getConexion();
        socioData = new SocioData();
        claseData = new ClaseData();
        paseData = new PaseData();
    }

    //validar asistencia
    private boolean validarAsistencia(Asistencia a) {
        if (a == null) {
            JOptionPane.showMessageDialog(null, "La asistencia no puede ser nula");
            return false;
        }

        Socio s = socioData.buscarSocioPorId(a.getSocio().getIdSocio());

        if (s == null) {
            JOptionPane.showMessageDialog(null, "El socio no existe o está inactivo");
            return false;
        }

        return true;
    }

}

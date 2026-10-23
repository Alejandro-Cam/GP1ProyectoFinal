package Main;

import Entidades.Socio;
import Persistencia.SocioData;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        SocioData socioData = new SocioData();
        
        Socio s = new Socio("34.000.000", "Alejandro", "Camargo", 30, "alejandro@ulp.com", "2664101010", true);
        /*
        //guardamos socio
        socioData.guardarSocio(s);
        System.out.println("Socio Guardado con exito " + s.toString());
        */
        //listar socios
        System.out.println("-------------------LISTA DE SOCIOS---------------------");
        List<Socio> lista = socioData.listarSocio();
        for (Socio socio : lista) {
            System.out.println(socio.toString());
        }
        
        
        
        
        
    }
}

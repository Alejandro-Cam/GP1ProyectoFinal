package Main;

import Entidades.Entrenador;
import Entidades.Socio;
import Persistencia.EntrenadorData;
import Persistencia.SocioData;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        SocioData socioData = new SocioData();
        /*
        Socio s = new Socio("34.000.000", "Alejandro", "Camargo", 30, "alejandro@ulp.com", "2664101010", true);
        
        //guardamos socio
        socioData.guardarSocio(s);
        System.out.println("Socio Guardado con exito " + s.toString());
        
        //listar socios
        System.out.println("-------------------LISTA DE SOCIOS---------------------");
        List<Socio> lista = socioData.listarSocio();
        for (Socio socio : lista) {
            System.out.println(socio.toString());
        }
        
        //buscar por DNI
        System.out.println("--------------BUSCAR POR DNI-------------");
        Socio a = socioData.buscarSocioPorDni("34.000.000");
        System.out.println("socio : " + s.getNombre());
        
        //modificar socio
        a.setCorreo("correoActualizado@ulp.com");
        socioData.modificarSocio(a);
        System.out.println("socio actualizado: " + a.toString());
        
        //baja logica
        socioData.bajaSocio(2);
        
        //alta logica
        socioData.altaSocio(2);
        */
        
        //----------------------ENTRENADOR-------------------------------
        Entrenador e = new Entrenador("10.000.000", "Claudio", "Gallo", "Musculacion", true);
        
        EntrenadorData entrenadorData = new EntrenadorData();
        
        //guardar entrenador
//        entrenadorData.guardarEntrenador(e);
        
        //buscar por id
//        Entrenador en = entrenadorData.buscarPorId(3);
//        System.out.println("Buscado: " + en.getApellido() + en.getDni());
        
        //Modificar 
//        en.setApellido("Berg");
//        entrenadorData.modificarEntrenador(en);
//        System.out.println("Modificado: " + en.toString());

    }
}

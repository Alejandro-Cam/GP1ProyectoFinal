package Entidades;

public class Entrenador {
    //atributos
    private int idEntrenador;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean estado;
    
    //constructor completo
    public Entrenador(int idEntrenador, String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.idEntrenador = idEntrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    //constructor sin id
    public Entrenador(String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    //constructor vacio
    public Entrenador() {}
    
    //getter and setter
    public int getIdEntrenador() {
        return idEntrenador;
    }
    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //toString
    @Override
    public String toString() {
        return "ID: " + idEntrenador +
                "Nombre: " + nombre + 
                "Apellido: " + apellido;
    }
}

package Entidades;

public class Socio {
    //atributos
    private int idSocios;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String telefono;
    private boolean estado;
    
    //constructor completo
    public Socio(int idSocios, String dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.idSocios = idSocios;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }
    
    //constructor sin id
    public Socio(String dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }
    
    //constructor vacio
    public Socio() {};
    
    //getter and setter
    public int getIdSocios() {
        return idSocios;
    }
    public void setIdSocios(int idSocios) {
        this.idSocios = idSocios;
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //toString 
    @Override
    public String toString(){
        return "ID: " + idSocios + "APELLIDO: " + apellido + " NOMBRE: " + nombre;
    }
}

package Entidades;

import java.time.LocalDate;

public class Asistencia {

    //atributos
    private int idAsistencia;
    private Socio socio;
    private Clase clase;
    private Pase pase;
    private LocalDate fechaAsistencia;

    //constructor completo
    public Asistencia(int idAsistencia, Socio socio, Clase clase, Pase pase, LocalDate fechaAsistencia) {
        this.idAsistencia = idAsistencia;
        this.socio = socio;
        this.clase = clase;
        this.pase = pase;
        this.fechaAsistencia = fechaAsistencia;
    }

    //constructor sin id
    public Asistencia(Socio socio, Clase clase, Pase pase, LocalDate fechaAsistencia) {
        this.socio = socio;
        this.clase = clase;
        this.pase = pase;
        this.fechaAsistencia = fechaAsistencia;
    }

    //constructor vacio
    public Asistencia() {
    }

    //getter and setter
    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Pase getPase() {
        return pase;
    }

    public void setPase(Pase pase) {
        this.pase = pase;
    }

    public LocalDate getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(LocalDate fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    //toString 
    @Override
    public String toString() {
        return "ID Asistencia: " + idAsistencia
                + " | Socio: " + socio
                + " | Clase: " + clase
                + " | Pase: " + pase
                + " | Fecha: " + fechaAsistencia;
    }
}

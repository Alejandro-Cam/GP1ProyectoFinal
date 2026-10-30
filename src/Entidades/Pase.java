package Entidades;

import java.time.LocalDate;

public class Pase {
    //atributos
    private int idPase;
    private Socio socio;
    private int cantidadEntradas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costo;
    private boolean estado;
    
    //constructor completo
    public Pase(int idPase, Socio socio, int cantidadEntradas, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.idPase = idPase;
        this.socio = socio;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
    }
    
    //constructor sin idPase
    public Pase(Socio socio, int cantidadEntradas, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.socio = socio;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaInicio.plusDays(30); // a la fecha de inicio le suma 30 dias automaticamente
        this.costo = costo;
        this.estado = estado;
    }
    
    //constructor vacio
    public Pase() {}
    
    //getter and setter
    public int getIdPase() {
        return idPase;
    }
    public void setIdPase(int idPase) {
        this.idPase = idPase;
    }
    public Socio getSocio() {
        return socio;
    }
    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    public int getCantidadEntradas() {
        return cantidadEntradas;
    }
    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
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
        return"ID Pase: " + idPase + 
                " | Entradas: " + cantidadEntradas + 
                " | Vence: " + fechaFin;
    }
    
}

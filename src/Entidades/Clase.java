package Entidades;

import java.time.LocalTime;

public class Clase {
    //atributos
    private int idClase;
    private String disciplina;
    private Entrenador entrenador;
    private LocalTime horario;
    private int capacidad;
    private boolean estado;
    
    //constructor completo
    public Clase(int idClase, String disciplina, Entrenador entrenador, LocalTime horario, int capacidad, boolean estado) {
        this.idClase = idClase;
        this.disciplina = disciplina;
        this.entrenador = entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    //constructor sin id
    public Clase(String disciplina, Entrenador entrenador, LocalTime horario, int capacidad, boolean estado) {
        this.disciplina = disciplina;
        this.entrenador = entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    //constructor vacio
    public Clase() {}
    
    //getter and setter
    public int getIdClase() {
        return idClase;
    }
    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public Entrenador getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
        return "ID: " + idClase + 
                " Disciplina: " + disciplina;
    }
}

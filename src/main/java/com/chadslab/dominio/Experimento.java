package com.chadslab.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Experimento {
    private int id;
    private int duracion;
    private String nombre;
    private Resultado resultado;
    private List<Investigador> investigadores;

    public Experimento(int duracion, String nombre, Resultado resultado) {
        this.duracion = duracion;
        this.nombre = nombre;
        this.resultado = resultado;
        investigadores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    @Override
    public String toString() {
        return "EXPERIMENTO: " +
                " duracion=" + duracion +
                ", nombre='" + nombre + '\'' +
                ", resultado=" + resultado +
                ", investigadores=" + investigadores;
    }
}

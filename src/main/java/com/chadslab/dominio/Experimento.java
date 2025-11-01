package com.chadslab.dominio;

import java.util.List;

public abstract class Experimento {
    private int id;
    private int duracion;
    private String nombre;
    private Resultado resultado;
    private List<Investigador> investigadores;

    public Experimento(int duracion, String nombre, Resultado resultado, List<Investigador> investigadores) {
        this.duracion = duracion;
        this.nombre = nombre;
        this.resultado = resultado;
        this.investigadores = investigadores;

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
}

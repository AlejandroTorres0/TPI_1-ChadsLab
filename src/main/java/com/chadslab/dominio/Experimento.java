package com.chadslab.dominio;

import java.util.List;

public abstract class Experimento {
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
}

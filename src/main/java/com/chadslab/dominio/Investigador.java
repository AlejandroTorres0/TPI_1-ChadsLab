package com.chadslab.dominio;

import java.util.ArrayList;
import java.util.List;

public class Investigador implements IExportable {
    private int id;
    private String nombre;
    private int edad;
    private List<Experimento> experimentos;

    public Investigador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        experimentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setExperimentos(List<Experimento> experimentos) {
        this.experimentos = experimentos;
    }

    public void setExperimento(Experimento experimento) {
        experimentos.add(experimento);
    }

    @Override
    public String toString() {
        return "INVESTIGADOR: " +
                " nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", experimentos=" + experimentos;
    }
}

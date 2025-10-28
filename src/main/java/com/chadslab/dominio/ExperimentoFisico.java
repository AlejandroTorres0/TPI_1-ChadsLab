package com.chadslab.dominio;

import java.util.List;

public class ExperimentoFisico extends Experimento{
    private String tipoReactivo;


    public ExperimentoFisico(int duracion, String nombre, Resultado resultado, List<Investigador> investigadores, String tipoReactivo) {
        super(duracion, nombre, resultado, investigadores);
        this.tipoReactivo = tipoReactivo;
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }
}

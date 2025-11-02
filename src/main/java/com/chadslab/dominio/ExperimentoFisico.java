package com.chadslab.dominio;

import java.util.List;

public class ExperimentoFisico extends Experimento{
    private String tipoReactivo;


    public ExperimentoFisico(int duracion, String nombre, Resultado resultado, String tipoReactivo) {
        super(duracion, nombre, resultado);
        this.tipoReactivo = tipoReactivo;
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }
}

package com.chadslab.service.experimento.factory.impl;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.ExperimentoFisico;
import com.chadslab.dominio.ExperimentoQuimico;
import com.chadslab.dominio.Resultado;
import com.chadslab.service.experimento.factory.ExperimentoFactory;

public class ExperimentoFactoryImpl implements ExperimentoFactory {

    @Override
    public Experimento crearExperimentoFisico(String nombre, int duracion, Resultado resultado, String instrumentoUtilizado) {
        return new ExperimentoFisico(duracion, nombre, resultado, instrumentoUtilizado);
    }

    @Override
    public Experimento crearExperimentoQuimico(String nombre, int duracion, Resultado resultado, String tipoReactivo) {
        return new ExperimentoQuimico(duracion, nombre, resultado, tipoReactivo);
    }
}

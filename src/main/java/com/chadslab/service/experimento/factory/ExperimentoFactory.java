package com.chadslab.service.experimento.factory;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Resultado;

public interface ExperimentoFactory {

    Experimento crearExperimentoFisico(String nombre, int duracion, Resultado resultado, String tipoReactivo);

    Experimento crearExperimentoQuimico(String nombre, int duracion, Resultado resultado, String instrumentoUtilizado);
}

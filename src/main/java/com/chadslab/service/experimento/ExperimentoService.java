package com.chadslab.service.experimento;

import com.chadslab.dominio.Experimento;

import java.util.List;

public interface ExperimentoService {

    double promedioDuracion();

    double porcentajeExito();

    List<Integer> getExitososYFallidos();

    List<Experimento> getExperimentos();

    int getExperimentosExitosos();

    int getExperimentosFallidos();

}

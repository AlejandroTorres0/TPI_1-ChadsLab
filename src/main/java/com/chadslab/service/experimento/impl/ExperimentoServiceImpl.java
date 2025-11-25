package com.chadslab.service.experimento.impl;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Resultado;
import com.chadslab.repository.experimentos.ExperimentoRepository;
import com.chadslab.service.experimento.ExperimentoService;

import java.util.ArrayList;
import java.util.List;

public class ExperimentoServiceImpl implements ExperimentoService {
    private ExperimentoRepository experimentoRepository ;

    public ExperimentoServiceImpl(ExperimentoRepository experimentoRepository) {
        this.experimentoRepository = experimentoRepository;
    }

    public double promedioDuracion() {
        List<Experimento> experimentos = experimentoRepository.getExperimentos();
        int totalDeExperimentos = experimentos.size();
        int sumaDeDuraciones = 0;

        if  (totalDeExperimentos == 0) {
            System.out.println("No se encontraron experimentos, no se puede calcular el promedio de duración");
            return 0.0;
        }

        for (Experimento experimento : experimentos) {
            sumaDeDuraciones = sumaDeDuraciones + experimento.getDuracion();
        }

        return (double) sumaDeDuraciones / totalDeExperimentos;
    }

    public double porcentajeExito() {
        List<Experimento> experimentos = experimentoRepository.getExperimentos();
        int totalDeExperimentos = experimentos.size();
        int experimentosExitosos = this.getExperimentosExitosos();

        if (totalDeExperimentos == 0) {
            System.out.println("No se encontraron experimentos, no se puede calcular el porcentaje de éxito");
            return 0.0;
        }

        return ((double) experimentosExitosos / totalDeExperimentos) * 100;
    }

    public List<Integer> getExitososYFallidos() {
        List<Integer> exitososYFallidos = new ArrayList<>();

        int experimentosFallidos = this.getExperimentosFallidos();
        int experimentosExitosos = this.getExperimentosExitosos();

        exitososYFallidos.add(experimentosExitosos);
        exitososYFallidos.add(experimentosFallidos);

        return exitososYFallidos;
    }

    public List<Experimento> getExperimentos() {
        return experimentoRepository.getExperimentos();
    }

    public int getExperimentosExitosos() {
        List<Experimento> experimentos = experimentoRepository.getExperimentos();
        int experimentosExitosos = 0;

        for  (Experimento experimento : experimentos) {
            if (experimento.getResultado() == Resultado.EXITOSO) {
                experimentosExitosos = experimentosExitosos + 1;
            }
        }

        return  experimentosExitosos;
    }

    public int getExperimentosFallidos() {
        List<Experimento> experimentos = experimentoRepository.getExperimentos();
        int experimentosFallidos = 0;

        for (Experimento experimento : experimentos) {
            if (experimento.getResultado() == Resultado.FALLIDO) {
                experimentosFallidos = experimentosFallidos + 1;
            }
        }

        return  experimentosFallidos;
    }
}

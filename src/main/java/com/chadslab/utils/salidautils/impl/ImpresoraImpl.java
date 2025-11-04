package com.chadslab.utils.salidautils.impl;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Investigador;
import com.chadslab.service.experimento.ExperimentoService;
import com.chadslab.service.investigador.InvestigadorService;
import com.chadslab.utils.salidautils.Impresora;

import java.util.List;

public class ImpresoraImpl implements Impresora {

    private ExperimentoService experimentoService;
    private InvestigadorService investigadorService;

    public ImpresoraImpl(ExperimentoService experimentoService, InvestigadorService investigadorService) {
        this.experimentoService = experimentoService;
        this.investigadorService = investigadorService;
    }

    @Override
    public void mostrarReporteSimple() {
        System.out.println("Reporte Simple de experimentos");
        System.out.println("Promedio de duracion de los experimentos: " + experimentoService.promedioDuracion());
        System.out.println("Porcentaje de éxtio global: " + experimentoService.porcentajeExito());
        System.out.println("--------------------------------");

    }

    @Override
    public void mostrarExitososYFallidos() {

        List<Integer> exitososYFallidos = experimentoService.getExitososYFallidos();

        System.out.println("Experimentos EXISTOSOS y FALLIDOS");
        System.out.println("Experimentos EXITOSOS:" + exitososYFallidos.getFirst());
        System.out.println("Experimentos FALLIDOS:" + exitososYFallidos.get(1));

    }

    @Override
    public void mostrarInvestigadorConMasExperimentos() {
        Investigador investigadorConMasExperimentos = investigadorService.investigadorConMasExperimentos();

        if (investigadorConMasExperimentos == null) {
            System.out.println("Investigador con mas experimentos no encontrado");
        }else {
            System.out.println("El investigador con más experimentos es: ");
            System.out.println(investigadorConMasExperimentos);
        }

    }

    @Override
    public void mostrarExperimentosPorTipoYResultado() {
        List<Experimento> experimentos = experimentoService.getExperimentos();
        System.out.println("Experimentos por Tipo y Resultado");
        int i = 0;
        for (Experimento experimento : experimentos) {
            System.out.println("EXPERIMENTO " + i + ":");
            System.out.println("- Nombre: " + experimento.getNombre());
            System.out.println("- Resultado: " + experimento.getResultado());
            System.out.println("- Tipo: " + experimento.getClass().getSimpleName());
            System.out.println("-------------------------------");
            i++;
        }
    }
}

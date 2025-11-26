package com.chadslab.service.laboratorio.impl;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Investigador;
import com.chadslab.dominio.Resultado;
import com.chadslab.repository.experimentos.ExperimentoRepository;
import com.chadslab.repository.investigadores.InvestigadorRepository;
import com.chadslab.service.experimento.factory.ExperimentoFactory;
import com.chadslab.service.laboratorio.LaboratorioService;

import java.util.List;

public class LaboratorioServiceImpl implements LaboratorioService {
    private InvestigadorRepository investigadorRepository;
    private ExperimentoRepository experimentoRepository;
    private ExperimentoFactory experimentoFactory;

    public LaboratorioServiceImpl(InvestigadorRepository investigadorRepository, ExperimentoRepository experimentoRepository, ExperimentoFactory experimentoFactory) {
        this.investigadorRepository = investigadorRepository;
        this.experimentoRepository = experimentoRepository;
        this.experimentoFactory = experimentoFactory;
    }

    @Override
    public Experimento registrarExperimentoFisico(String nombre, int duracion, Resultado resultado, String instrumentoUtilizado, List<Integer> idsInvestigadores) {
        List<Investigador> investigadores;

        try {
            investigadores = investigadorRepository.getInvestigadoresPorIds(idsInvestigadores);
        } catch (Exception ex) {
            System.out.println("Error al cargar el experimento: " + ex.getMessage());
            return null;
        }

        if (investigadores.size() != idsInvestigadores.size()) {
            System.out.println("No se encontraron todos los investigadores solicitados. IDs inválidos.");
            return null;
        }

        Experimento nuevoExperimento = experimentoFactory.crearExperimentoFisico(nombre, duracion, resultado, instrumentoUtilizado);
        nuevoExperimento.setInvestigadores(investigadores);

        Experimento expGuardado = experimentoRepository.guardar(nuevoExperimento);

        for (Investigador inv : investigadores) {
            inv.setExperimento(expGuardado);
        }

        return expGuardado;
    }

    @Override
    public Experimento registrarExperimentoQuimico(String nombre, int duracion, Resultado resultado, String tipoReactivo, List<Integer> idsInvestigadores) {
        List<Investigador> investigadores;

        try {
            investigadores = investigadorRepository.getInvestigadoresPorIds(idsInvestigadores);
        } catch (Exception ex) {
            System.out.println("Error al cargar el experimento: " + ex.getMessage());
            return null;
        }

        if (investigadores.size() != idsInvestigadores.size()) {
            System.out.println("No se encontraron todos los investigadores solicitados. IDs inválidos.");
            return null;
        }

        Experimento nuevoExperimento = experimentoFactory.crearExperimentoQuimico(nombre, duracion,  resultado, tipoReactivo);
        nuevoExperimento.setInvestigadores(investigadores);

        Experimento expGuardado = experimentoRepository.guardar(nuevoExperimento);

        for (Investigador inv : investigadores) {
            inv.setExperimento(expGuardado);
        }

        return expGuardado;
    }
}

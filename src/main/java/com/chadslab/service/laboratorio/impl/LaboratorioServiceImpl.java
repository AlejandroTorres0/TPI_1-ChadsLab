package com.chadslab.service.laboratorio.impl;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Investigador;
import com.chadslab.repository.experimentos.ExperimentoRepository;
import com.chadslab.repository.investigadores.InvestigadorRepository;
import com.chadslab.service.laboratorio.LaboratorioService;

import java.util.List;

public class LaboratorioServiceImpl implements LaboratorioService {
    private InvestigadorRepository investigadorRepository;
    private ExperimentoRepository experimentoRepository;

    public LaboratorioServiceImpl(InvestigadorRepository investigadorRepository, ExperimentoRepository experimentoRepository) {
        this.investigadorRepository = investigadorRepository;
        this.experimentoRepository = experimentoRepository;
    }

    public Experimento registrarExperimentoAsociado(Experimento e, List<Integer> idsInvestigadores) {
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

        e.setInvestigadores(investigadores);

        Experimento expGuardado = experimentoRepository.guardar(e);

        for (Investigador inv : investigadores) {
            inv.setExperimento(expGuardado);
        }

        return expGuardado;
    }
}

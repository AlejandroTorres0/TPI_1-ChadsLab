package com.chadslab.service;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Investigador;
import com.chadslab.repository.experimentos.ExperimentoRepository;
import com.chadslab.repository.investigadores.InvestigadorRepository;

import java.util.List;

public class LaboratorioService {
    private InvestigadorRepository investigadorRepository;
    private ExperimentoRepository experimentoRepository;

    public LaboratorioService(InvestigadorRepository investigadorRepository, ExperimentoRepository experimentoRepository) {
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

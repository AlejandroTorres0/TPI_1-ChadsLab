package com.chadslab.service.investigador.impl;

import com.chadslab.dominio.Investigador;
import com.chadslab.repository.investigadores.InvestigadorRepository;
import com.chadslab.service.archivos.ArchivosInvestigadorService;
import com.chadslab.service.investigador.InvestigadorService;

import java.util.List;
import java.util.NoSuchElementException;

public class InvestigadorServiceImpl implements InvestigadorService {
    private InvestigadorRepository investigadorRepository;
    private ArchivosInvestigadorService archivosInvestigadorService;

    public InvestigadorServiceImpl(InvestigadorRepository investigadorRepository, ArchivosInvestigadorService archivosInvestigadorService) {
        this.investigadorRepository = investigadorRepository;
        this.archivosInvestigadorService = archivosInvestigadorService;

    }

    public void registrarInvestigador(String nombre, int edad) {
        Investigador investigador = new Investigador(nombre, edad);

        investigadorRepository.guardar(investigador);
    }

    public Investigador investigadorConMasExperimentos() {
        List<Investigador> investigadores = investigadorRepository.getInvestigadores();
        Investigador investigadorConMasExperimentos;

        try {
            investigadorConMasExperimentos = investigadores.getFirst();
        }
        catch (NoSuchElementException e) {
            return null;
        }

        for (Investigador investigador : investigadores) {
            if (investigadorConMasExperimentos.getExperimentos().size() < investigador.getExperimentos().size()) {
                investigadorConMasExperimentos = investigador;
            }
        }

        return investigadorConMasExperimentos;
    }

    public void exportarInvestigadoresCSV() {

        archivosInvestigadorService.exportarInvestigadoresCSV(investigadorRepository.getInvestigadores());

    }
}

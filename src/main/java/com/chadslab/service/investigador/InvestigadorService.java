package com.chadslab.service.investigador;

import com.chadslab.dominio.Investigador;
import com.chadslab.repository.investigadores.InvestigadorRepository;
import com.chadslab.service.archivos.ArchivosInvestigadorService;

import java.util.List;
import java.util.NoSuchElementException;

public class InvestigadorService {
    private InvestigadorRepository investigadorRepository;
    private ArchivosInvestigadorService archivosInvestigadorService;

    public InvestigadorService(InvestigadorRepository investigadorRepository, ArchivosInvestigadorService archivosInvestigadorService) {
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

package com.chadslab.service.investigador;

import com.chadslab.dominio.Investigador;

public interface InvestigadorService {

    void registrarInvestigador(String nombre, int edad);

    Investigador investigadorConMasExperimentos();

    void exportarInvestigadoresCSV();

}

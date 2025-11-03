package com.chadslab.service.archivos;

import com.chadslab.dominio.Investigador;

import java.io.IOException;
import java.util.List;

public interface ArchivosInvestigadorService {

    void exportarInvestigadoresCSV(List<Investigador> investigadores);

}

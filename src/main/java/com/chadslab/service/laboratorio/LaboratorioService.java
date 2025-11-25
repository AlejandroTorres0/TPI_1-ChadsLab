package com.chadslab.service.laboratorio;

import com.chadslab.dominio.Experimento;

import java.util.List;

public interface LaboratorioService {

    Experimento registrarExperimentoAsociado(Experimento e, List<Integer> idsInvestigadores);

}

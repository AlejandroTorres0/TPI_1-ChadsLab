package com.chadslab.service.laboratorio;

import com.chadslab.dominio.Experimento;
import com.chadslab.dominio.Resultado;

import java.util.List;

public interface LaboratorioService {

    Experimento registrarExperimentoQuimico(String nombre, int duracion, Resultado resultado, String tipoReactivo, List<Integer> idsInvestigadores);

    Experimento registrarExperimentoFisico(String nombre, int duracion, Resultado resultado, String instrumento, List<Integer> idsInvestigadores);

}

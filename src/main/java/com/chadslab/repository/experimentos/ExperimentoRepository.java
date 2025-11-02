package com.chadslab.repository.experimentos;

import com.chadslab.dominio.Experimento;
import java.util.List;
import java.util.Optional;

public interface ExperimentoRepository {

    Experimento guardar(Experimento e);

    void eliminar(Experimento e);

    Optional<Experimento> getExperimentoPorId(int id);

    List<Experimento> getExperimentosPorIds(List<Integer> ids);

    List<Experimento> getExperimentos();
}

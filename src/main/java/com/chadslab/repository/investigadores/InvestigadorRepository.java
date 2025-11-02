package com.chadslab.repository.investigadores;

import com.chadslab.dominio.Investigador;

import java.util.List;
import java.util.Optional;

public interface InvestigadorRepository {
    Investigador guardar(Investigador i);

    void eliminar(Investigador i);

    Optional<Investigador> getInvestigadorPorId(int id);

    List<Investigador> getInvestigadores();

    List<Investigador> getInvestigadoresPorIds(List<Integer> ids);
}

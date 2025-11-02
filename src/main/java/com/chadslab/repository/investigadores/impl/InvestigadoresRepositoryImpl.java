package com.chadslab.repository.investigadores.impl;

import com.chadslab.dominio.Investigador;
import com.chadslab.repository.investigadores.InvestigadorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvestigadoresRepositoryImpl implements InvestigadorRepository {
    List<Investigador> investigadores;
    int proximoId = 1;

    @Override
    public Investigador guardar(Investigador i) {
        i.setId(proximoId++);
        investigadores.add(i);

        return i;
    }

    @Override
    public void eliminar(Investigador i) {
        investigadores.remove(i);
    }

    @Override
    public Optional<Investigador> getInvestigadorPorId(int id) {
        return investigadores.stream()
                .filter(inv -> inv.getId() == id)
                .findFirst();
    }

    @Override
    public List<Investigador> getInvestigadores() {
        return new ArrayList<>(investigadores);
    }

    @Override
    public List<Investigador> getInvestigadoresPorIds(List<Integer> ids) {
        return investigadores.stream()
                .filter(inv -> ids.contains(inv.getId()))
                .collect(Collectors.toList());
    }
}

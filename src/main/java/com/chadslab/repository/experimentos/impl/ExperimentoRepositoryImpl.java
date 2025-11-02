package com.chadslab.repository.experimentos.impl;

import com.chadslab.dominio.Experimento;
import com.chadslab.repository.experimentos.ExperimentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExperimentoRepositoryImpl implements ExperimentoRepository {
    List<Experimento> experimentos;
    int proximoId = 1;

    @Override
    public Experimento guardar(Experimento e) {
        e.setId(proximoId++);
        experimentos.add(e);

        return e;
    }

    @Override
    public void eliminar(Experimento e) {
        experimentos.remove(e);
    }

    @Override
    public List<Experimento> getExperimentos() {
        return new ArrayList<>(experimentos);
    }

    @Override
    public Optional<Experimento> getExperimentoPorId(int id) {
        return experimentos.stream()
                .filter(inv -> inv.getId() == id)
                .findFirst();
    }

    @Override
    public List<Experimento> getExperimentosPorIds(List<Integer> ids) {
        return experimentos.stream()
                .filter(inv -> ids.contains(inv.getId()))
                .collect(Collectors.toList());
    }
}

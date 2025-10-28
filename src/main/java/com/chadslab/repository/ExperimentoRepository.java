package com.chadslab.repository;

import com.chadslab.dominio.Experimento;

import java.util.List;

public class ExperimentoRepository {
    private List<Experimento> experimentos;

    public void guardar(Experimento e) {
        experimentos.add(e);
    }

    public void eliminar(Experimento e) {
        experimentos.remove(e);
    }

    public List<Experimento> getExperimentos() {
        return experimentos;
    }

}

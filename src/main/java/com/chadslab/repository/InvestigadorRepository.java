package com.chadslab.repository;

import com.chadslab.dominio.Investigador;

import java.util.List;

public class InvestigadorRepository {
    private List<Investigador> investigadores;

    public void guardar(Investigador i) {
        investigadores.add(i);
    }

    public void eliminar(Investigador i) {
        investigadores.remove(i);
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
}

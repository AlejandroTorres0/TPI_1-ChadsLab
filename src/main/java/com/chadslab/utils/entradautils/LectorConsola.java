package com.chadslab.utils.entradautils;

import com.chadslab.dominio.Resultado;

import java.util.List;

public interface LectorConsola {

    int leerInt(String mensaje);

    String leerString(String mensaje);

    List<Integer> leerIntLista(String mensaje);

    Resultado leerResultado(String mensaje);

}

package com.chadslab.dominio;

import java.util.List;

public class ExperimentoQuimico extends Experimento {
    private String instrumentoUtilizado;

    public ExperimentoQuimico(int duracion, String nombre, Resultado resultado, List<Investigador> investigadores, String instrumentoUtilizado) {
        super( duracion, nombre, resultado, investigadores);
        this.instrumentoUtilizado = instrumentoUtilizado;
    }

    public String getInstrumentoUtilizado() {
        return instrumentoUtilizado;
    }


}

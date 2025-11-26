package com.chadslab.controller.impl;

import com.chadslab.controller.LaboratorioFlowController;
import com.chadslab.dominio.Resultado;
import com.chadslab.service.investigador.InvestigadorService;
import com.chadslab.service.laboratorio.LaboratorioService;
import com.chadslab.utils.entradautils.LectorConsola;

import java.util.List;

public class LaboratorioFlowControllerImpl implements LaboratorioFlowController {

    private final LectorConsola lector;
    private final LaboratorioService laboratorioService;
    private final InvestigadorService investigadorService;

    public LaboratorioFlowControllerImpl(LectorConsola lector, LaboratorioService laboratorioService, InvestigadorService investigadorService) {
        this.lector = lector;
        this.laboratorioService = laboratorioService;
        this.investigadorService = investigadorService;
    }

    @Override
    public void registrarInvestigador() {
        String mensajeNombre = "Ingrese el nombre del investigador";
        String mensajeEdad = "Ingrese la edad del investigador";

        String nombre = lector.leerString(mensajeNombre);
        int edad = lector.leerInt(mensajeEdad);

        investigadorService.registrarInvestigador(nombre, edad);
        System.out.println("El investigador se ha registrado correctamente");
    }

    @Override
    public void registrarExperimento() {
        String mensajeOpcionExp = "¿Qué tipo de experimento desea registrar?" + "\n" + "1. Químico" + "\n" + "2. Físico";
        int opcion = lector.leerInt(mensajeOpcionExp);

        String mensajeNombre = "Ingrese el nombre del experimento";
        String mensajeDuracion = "Ingrese la duracion del experimento en minutos";

        String nombre = lector.leerString(mensajeNombre);
        int duracion = lector.leerInt(mensajeDuracion);

        String mensajeOpcionResultado = "Ingrese el resultado del experimento";
        Resultado resultado = lector.leerResultado(mensajeOpcionResultado);

        String mensajeInves = "Ingrese las ids de los investigadores que participaron en el experimento, " +
                "ingrese -1 para finalizar la carga de ids";
        List<Integer> idsInvestigadores = lector.leerIntLista(mensajeInves);


        if (opcion == 1){
            String mensajeTipoReactivo = "Ingrese el tipo de reactivo del experimento";
            String tipoReactivo = lector.leerString(mensajeTipoReactivo);

            laboratorioService.registrarExperimentoQuimico(nombre, duracion, resultado, tipoReactivo, idsInvestigadores);

        } else if (opcion == 2) {
            String mensajeInstrumentoUtilizado = "Ingrese el instrumento utilizado en el experimento";
            String instrumentoUtilizado = lector.leerString(mensajeInstrumentoUtilizado);

            laboratorioService.registrarExperimentoFisico(nombre, duracion, resultado, instrumentoUtilizado, idsInvestigadores);
        }
        else {
            System.out.println("Error! Ingrese una opción correcta");
        }
    }
}

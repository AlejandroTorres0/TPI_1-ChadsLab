package com.chadslab.service.menu.impl;

import com.chadslab.dominio.*;
import com.chadslab.service.LaboratorioService;
import com.chadslab.service.experimento.ExperimentoService;
import com.chadslab.service.investigador.InvestigadorService;
import com.chadslab.utils.entradautils.LectorConsola;
import com.chadslab.service.menu.MenuService;
import com.chadslab.utils.salidautils.Impresora;

import java.util.List;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private LectorConsola lector;
    private ExperimentoService experimentoService;
    private InvestigadorService investigadorService;
    private LaboratorioService laboratorioService;
    private Impresora impresora;

    public MenuServiceImpl(ExperimentoService experimentoService, InvestigadorService investigadorService, LaboratorioService laboratorioService, LectorConsola lector, Impresora impresora) {
        this.lector = lector;
        this.experimentoService = experimentoService;
        this.investigadorService = investigadorService;
        this.laboratorioService = laboratorioService;
        this.impresora = impresora;

    }
    @Override
    public int seleccionarOpcion() {
        Scanner sc = new Scanner(System.in);
        int condicion = 0;

        do{
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Registrar un Investigador");
            System.out.println("2. Registrar un Experimento");
            System.out.println("3. Mostrar Experimentos Exitosos y Fallidos");
            System.out.println("4. Generar Reporte Simple");
            System.out.println("5. Consultar Investigador con más Experimentos");
            System.out.println("6. Exportar Investigadores en formato CSV");
            System.out.println("7. Consultar Experimentos por Tipo y Resultado");
            System.out.println("8. Salir");

            condicion = sc.nextInt();
            ejecutar(condicion);

        }while(condicion != 8);

        sc.close();
        return condicion;
    }

    @Override
    public void ejecutar(int opcion) {
        switch(opcion) {
            case 1:
                this.procesarRegistroInvestigador();
                break;
            case 2:
                this.procesarRegistroExperimento();
                break;
            case 3:
                impresora.mostrarExitososYFallidos();
                break;
            case 4:
                impresora.mostrarReporteSimple();
                break;
            case 5:
                impresora.mostrarInvestigadorConMasExperimentos();
                break;
            case 6:
                investigadorService.exportarInvestigadoresCSV();
                break;
            case 7:
                impresora.mostrarExperimentosPorTipoYResultado();
                break;
            default:
                break;
        }
    }

    @Override
    public void procesarRegistroInvestigador() {
        String mensajeNombre = "Ingrese el nombre del investigador";
        String mensajeEdad = "Ingrese la edad del investigador";

        String nombre = lector.leerString(mensajeNombre);
        int edad = lector.leerInt(mensajeEdad);

        investigadorService.registrarInvestigador(nombre, edad);

        System.out.println("El investigador se ha registrado correctamente");
    }

    @Override
    public void procesarRegistroExperimento() {
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

        Experimento experimentoAGuardar;

        if (opcion == 1){
            String mensajeInstrumentoUtilizado = "Ingrese el instrumento utilizado en el experimento";
            String instrumentoUtilizado = lector.leerString(mensajeInstrumentoUtilizado);

            experimentoAGuardar = new ExperimentoQuimico(duracion, nombre, resultado, instrumentoUtilizado);

            laboratorioService.registrarExperimentoAsociado(experimentoAGuardar, idsInvestigadores);

        } else if (opcion == 2) {
            String mensajeTipoReactivo = "Ingrese el tipo de reactivo del experimento";
            String tipoReactivo = lector.leerString(mensajeTipoReactivo);

            experimentoAGuardar = new ExperimentoFisico(duracion, nombre, resultado, tipoReactivo);

            laboratorioService.registrarExperimentoAsociado(experimentoAGuardar, idsInvestigadores);
        }
        else {
            System.out.println("Error! Ingrese una opción correcta");
        }
    }
}

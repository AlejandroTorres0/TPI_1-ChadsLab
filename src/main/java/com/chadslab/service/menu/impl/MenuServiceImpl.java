package com.chadslab.service.menu.impl;

import com.chadslab.controller.LaboratorioFlowController;
import com.chadslab.dominio.*;
import com.chadslab.service.investigador.InvestigadorService;
import com.chadslab.service.menu.MenuService;
import com.chadslab.utils.salidautils.Impresora;

import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private LaboratorioFlowController laboratorioFlowController;
    private InvestigadorService investigadorService;
    private Impresora impresora;

    public MenuServiceImpl(InvestigadorService investigadorService, Impresora impresora, LaboratorioFlowController laboratorioFlowController) {
        this.laboratorioFlowController = laboratorioFlowController;
        this.investigadorService = investigadorService;
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
                laboratorioFlowController.registrarInvestigador();
                break;
            case 2:
                laboratorioFlowController.registrarExperimento();
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
}

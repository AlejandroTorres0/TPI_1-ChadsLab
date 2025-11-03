package com.chadslab;

import com.chadslab.repository.experimentos.ExperimentoRepository;
import com.chadslab.repository.experimentos.impl.ExperimentoRepositoryImpl;
import com.chadslab.repository.investigadores.InvestigadorRepository;
import com.chadslab.repository.investigadores.impl.InvestigadoresRepositoryImpl;
import com.chadslab.service.LaboratorioService;
import com.chadslab.service.archivos.impl.ArchivosInvestigadorServiceImpl;
import com.chadslab.service.experimento.ExperimentoService;
import com.chadslab.service.investigador.InvestigadorService;
import com.chadslab.service.menu.MenuService;
import com.chadslab.service.menu.impl.MenuServiceImpl;
import com.chadslab.utils.entradautils.LectorConsola;
import com.chadslab.utils.salidautils.Impresora;
import com.chadslab.utils.salidautils.impl.ImpresoraImpl;

public class App {
    public static void main(String[] args) {
        LectorConsola lectorConsola = new LectorConsola();


        ArchivosInvestigadorServiceImpl archivosInvestigadorService = new ArchivosInvestigadorServiceImpl();

        InvestigadorRepository investigadorRepository = new InvestigadoresRepositoryImpl();
        InvestigadorService investigadorService = new InvestigadorService(investigadorRepository, archivosInvestigadorService);

        ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();
        ExperimentoService experimentoService = new ExperimentoService(experimentoRepository);


        LaboratorioService laboratorioService = new LaboratorioService(investigadorRepository, experimentoRepository);

        Impresora impresora = new ImpresoraImpl(experimentoService, investigadorService);

        MenuService menuService = new MenuServiceImpl(experimentoService, investigadorService, laboratorioService, lectorConsola, impresora);

        System.out.print("Bienvenido a ChadsLab ");

        menuService.seleccionarOpcion();
    }
}

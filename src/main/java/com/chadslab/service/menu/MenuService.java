package com.chadslab.service.menu;

public interface MenuService {

    int seleccionarOpcion();

    void ejecutar(int opcion);

    void procesarRegistroInvestigador();

    void procesarRegistroExperimento();
}

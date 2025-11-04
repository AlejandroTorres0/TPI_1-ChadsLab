package com.chadslab.service.archivos.impl;

import com.chadslab.dominio.Investigador;
import com.chadslab.service.archivos.ArchivosInvestigadorService;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivosInvestigadorServiceImpl implements ArchivosInvestigadorService {

    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\com\\chadslab\\resource\\";

    CSVWriter csvWriter;

    @Override
    public void exportarInvestigadoresCSV(List<Investigador> investigadores) {
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("investigadores.csv");

        try {
            this.csvWriter = new CSVWriter(new FileWriter(ruta));

            String[] encabezado = {"Nombre", "Edad", "Cantidad de experimentos"};
            this.csvWriter.writeNext(encabezado);

            for (Investigador investigador : investigadores) {

                String[] datos = {investigador.getNombre(), String.valueOf(investigador.getEdad()), String.valueOf(investigador.getExperimentos().size())};
                this.csvWriter.writeNext(datos);

            }

            System.out.println("Exportación de investigadores completada");
            this.csvWriter.close();
        } catch (IOException ex) {
            System.out.println("Error al cargar archivos investigadores, motivo: " + ex.getMessage().concat("Ubicacion archivo : " + ruta));
        }

    }
}

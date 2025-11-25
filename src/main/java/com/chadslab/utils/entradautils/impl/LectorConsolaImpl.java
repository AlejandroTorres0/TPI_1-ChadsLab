package com.chadslab.utils.entradautils.impl;

import com.chadslab.dominio.Resultado;
import com.chadslab.utils.entradautils.LectorConsola;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LectorConsolaImpl implements LectorConsola {
    private Scanner scanner;

    public LectorConsolaImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int leerInt(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                int numero = Integer.parseInt(scanner.nextLine());

                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número válido");
                scanner.nextLine();
            }
        }
    }

    @Override
    public String leerString(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    @Override
    public List<Integer> leerIntLista(String mensaje) {
        List<Integer> lista = new ArrayList<>();
        System.out.println(mensaje);
        while (true) {
            int num = leerInt("Id: ");
            if (num == -1) {
                break;
            }
            lista.add(num);
        }
        return lista;
    }

    @Override
    public Resultado leerResultado(String mensaje) {
        int i = 0;
        for (Resultado resultado : Resultado.values()) {
            System.out.println((i + 1) + ". " + resultado.name());
            i++;
        }
        int opcionResultado = this.leerInt(mensaje);
        Resultado resultado = Resultado.values()[opcionResultado - 1];
        return resultado;
    }
}

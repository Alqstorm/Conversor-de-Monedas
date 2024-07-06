package com.coversor.rieh;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir de Dolares a Euros.");
            System.out.println("2. Convertir de Euros a Dolares.");
            System.out.println("3. Convertir de Dolares a Libras de Esterlina.");
            System.out.println("4. Convertir de Dolares a Libra Egipcia.");
            System.out.println("5. Convertir de Rupias Nepalís a Pesos Argentinos.");

            //puedo agregar opciones Ilimitadas
            //System.out.println();
            //System.out.println();
            //System.out.println();
            //System.out.println();
            System.out.println("9. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();
// recordar que para agregar los distintos tipos de monedas debemos usar
// case dentro del swtich y consultar la guia de la api para poner las respectivas monedas!!!!
            switch (option) {
                case 1:
                    System.out.println("Ingrese la cantidad en Dolares: ");
                    double usd = scanner.nextDouble();
                    double eur = converter.convert("USD", "EUR", usd);
                    System.out.println(usd + " Dolares son " + eur + " Euros");
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad en Euros: ");
                    double cantidadEuros = scanner.nextDouble();
                    double cantidadUsd = converter.convert("EUR", "USD", cantidadEuros);
                    System.out.println(cantidadEuros + " Euros son " + cantidadUsd + " Dolares");
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad en Dolares: ");
                    double usdALibra = scanner.nextDouble();
                    double libraCantidad = converter.convert("USD","GBP", usdALibra);
                    System.out.println(usdALibra + " Dolares son " + libraCantidad + " Libra de Esterlina");
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad en Dolares: ");
                    double libraEgipcia = scanner.nextDouble();
                    double usdMonto = converter.convert("USD","EGP", libraEgipcia);
                    System.out.println(libraEgipcia + " Dolares son " + usdMonto + "Libra Egipcia");
                    break;
                case 5:
                    System.out.println("\"Ingrese la cantidad en Rupia nepalí: ");
                    double rupiaNepali = scanner.nextDouble();
                    double pesoArg = converter.convert("NPR", "ARS", rupiaNepali);
                    System.out.println(rupiaNepali + "Rupia Nepalí son " + pesoArg + "Pesos Argentinos");
                    break;
                //case numeroDeOpcion :
                    //System.out.println("\"Ingrese la cantidad en Moneda1: ");
                    //double moneda1 = scanner.nextDouble();
                    //double moneda2 = converter.convert("M1", "M2", moneda1);
                    //System.out.println(moneda1 + "moneda1 son " + moneda2 + "moneda2");
                    //break;
                    //no olvidar el break que es muy nesesario sino no terminara el codigo repasar...
                case 9:
                    exit = true;
                    System.out.println("Gracias Por Usar...");
                    break;
                default:
                    System.out.println("No Valido. Ingrese de nuevo Por Favor.");
            }
        }

        scanner.close();
    }
}

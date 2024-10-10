package com.alura.convertidormoneda.principal;

import com.alura.convertidormoneda.calculos.Convertir;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int opcion;

        Convertir importe1 = new Convertir(0,0,0);

        Scanner teclado = new Scanner(System.in);
        try {
            while (true) {
                double importe = 0;
                String monedaOrigen = "";
                String monedaDestino = "";

                System.out.println("**************************************************");
                System.out.println("Conversor de Monedas");
                System.out.println("**************************************************");

                System.out.println("1. Dólar           -> Peso Argentino");
                System.out.println("2. Peso Argentino  -> Dólar");
                System.out.println("3. Dólar           -> Real Brasileño");
                System.out.println("4. Real Brasileño  -> Dólar");
                System.out.println("5. Dólar           -> Peso Colombiano");
                System.out.println("6. Peso Colombiano -> Dólar");
                System.out.println("7. Dólar           -> Sol Peruano");
                System.out.println("8. Sol Peruano     -> Dólar");
                System.out.println("9. Salir");

                System.out.print("Ingrese una opción válida: ");
                if (teclado.hasNextInt()) {
                    opcion = teclado.nextInt();
                    if (opcion >= 1 && opcion <= 9) {
                        switch (opcion) {
                            case 1:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "USD";
                                monedaDestino = "ARS";
                                break;
                            case 2:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "ARS";
                                monedaDestino = "USD";
                                break;
                            case 3:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "USD";
                                monedaDestino = "BRL";
                                break;
                            case 4:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "BRL";
                                monedaDestino = "USD";
                                break;
                            case 5:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "USD";
                                monedaDestino = "COP";
                                break;
                            case 6:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "COP";
                                monedaDestino = "USD";
                                break;
                            case 7:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "USD";
                                monedaDestino = "PEN";
                                break;
                            case 8:
                                importe = importe1.respuestaImporte();
                                monedaOrigen = "PEN";
                                monedaDestino = "USD";
                                break;
                            case 9:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Error: Debes seleccionar una opción válida (1-7).");
                    }
                } else {
                    System.out.println("Error: Entrada no válida. Debes ingresar un número.");
                    teclado.next();
                }

                double ImporteConvertido = importe1.convertirMoneda(monedaOrigen, monedaDestino, importe);
                System.out.println(importe + " " + monedaOrigen + " = " + ImporteConvertido + " " + monedaDestino);
                }
            } catch (Exception e) {
                e.printStackTrace();
           }

    }
}
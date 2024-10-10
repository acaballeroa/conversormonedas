package com.alura.convertidormoneda.calculos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Convertir {

    private double importe;
    private double importeConvertido;
    private double conversionRate;
    private static final String API_KEY = "d1fd0585973f1c808d07466f";

    public Convertir(double importe) {
        this.importe = importe;
    }

    public Convertir(double importe, double importeConvertido, double conversionRate) {
        this.importe = importe;
        this.importeConvertido = importeConvertido;
        this.conversionRate = conversionRate;
    }

    public double convertirMoneda(String monedaOrigen, String monedaDestino, double importe) throws Exception {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;
        URL url = new URL(urlStr);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException("HTTP código de error : " + conexion.getResponseCode());
        }

        BufferedReader leer = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String line;
        while ((line = leer.readLine()) != null) {
            respuesta.append(line);
        }
        leer.close();

        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(respuesta.toString(), JsonObject.class);

        this.conversionRate = jsonResponse.get("conversion_rate").getAsDouble();

        importeConvertido = this.importe * this.conversionRate;

        return importeConvertido;
    }

    public double respuestaImporte() {
        double importeAConvertir;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la importe a convertir: ");
        while (true) {
            if (!teclado.hasNextDouble()) {
                System.out.println("Error, introduce un número.");
                teclado.next();
            } else {
                importe = teclado.nextDouble();
                if (importe > 0) {
                    break;
                }else{
                    System.out.println("Error, introduce un número positivo.");
                }
            }
            System.out.print("Introduce la importe a convertir: ");
        }
        importeAConvertir = this.importe;
        return importeAConvertir;
    }
}

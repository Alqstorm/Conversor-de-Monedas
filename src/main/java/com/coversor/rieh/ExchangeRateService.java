package com.coversor.rieh;
//este import no se por que no funciona.
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateService {
    private static final String API_KEY = "aa6f6a3e97044815953116c4";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/aa6f6a3e97044815953116c4/latest/USD";

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            // Crear URL y conexión
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parsear JSON
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(response.toString()).getAsJsonObject();

            // Acceder a la tasa de cambio deseada
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            double exchangeRate = rates.get(toCurrency).getAsDouble();

            return exchangeRate;
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}

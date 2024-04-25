import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiTasaCambio {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/48aa416fc9ced631f9e80abf/latest/USD";

    public double obtenerTasa(String monedaOrigen, String monedaDestino) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Procesar la respuesta JSON para obtener la tasa de cambio
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
            double tasa = rates.get(monedaDestino).getAsDouble();
            return tasa;

        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Manejar el error devolviendo un valor negativo
        }
    }
}
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConvertidorDeMoneda {
    private String sourceCurrency;
    private String targetCurrency;
    private final Scanner scanner = new Scanner(System.in);

    public void convertirMoneda(HistorialDeConversion historial) {
        String[] currencies = {"Peso Mexicano (MXN)", "Peso Argentino (ARS)", "Peso Colombiano (COP)", "Dólar (USD)", "Euro (EUR)", "Libra Esterlina (GBP)", "Yen Japonés (JPY)", "Won Sul-Coreano (KRW)"};

        if (sourceCurrency == null || targetCurrency == null) {
            System.out.println("Indica tu moneda base:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println((i + 1) + ". " + currencies[i]);
            }
            int sourceChoice = scanner.nextInt();
            sourceCurrency = getCurrencyCode(currencies[sourceChoice - 1]);

            System.out.println("Selecciona la moneda de destino:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println((i + 1) + ". " + currencies[i]);
            }
            int targetChoice = scanner.nextInt();
            targetCurrency = getCurrencyCode(currencies[targetChoice - 1]);
        }

        System.out.println("Ingrese la cantidad a convertir:");
        double amount = scanner.nextDouble();

        try {
            double conversionRate = getConversionRate(sourceCurrency, targetCurrency);
            double result = amount * conversionRate;
            System.out.println("Resultado de la conversión: " + amount + " " + sourceCurrency + " = " + result + " " + targetCurrency);
            historial.addEntry("Convertido " + amount + " " + sourceCurrency + " a " + result + " " + targetCurrency);

            System.out.println("¿Desea convertir otra cantidad de " + sourceCurrency + " a " + targetCurrency + "? (s/n)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("s")) {
                convertirMoneda(historial);
            } else {
                sourceCurrency = null;
                targetCurrency = null;
            }

        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }

    private String getCurrencyCode(String currencyName) {
        switch (currencyName) {
            case "Peso Mexicano (MXN)":
                return "MXN";
            case "Peso Argentino (ARS)":
                return "ARS";
            case "Peso Colombiano (COP)":
                return "COP";
            case "Dólar (USD)":
                return "USD";
            case "Euro (EUR)":
                return "EUR";
            case "Libra Esterlina (GBP)":
                return "GBP";
            case "Yen Japonés (JPY)":
                return "JPY";
            case "Won Sul-Coreano (KRW)":
                return "KRW";
            default:
                return null;
        }
    }

    private double getConversionRate(String baseCurrency, String targetCurrency) throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/1037ae973d901a6844f1f32b/latest/" + baseCurrency;
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            if (conversionRates != null && conversionRates.has(targetCurrency)) {
                return conversionRates.get(targetCurrency).getAsDouble();
            } else {
                throw new Exception("La tasa de conversión para " + targetCurrency + " no está disponible en el JSON recibido");
            }
        } else {
            throw new Exception("Error al obtener la tasa de conversión. Código de respuesta: " + responseCode);
        }
    }
}

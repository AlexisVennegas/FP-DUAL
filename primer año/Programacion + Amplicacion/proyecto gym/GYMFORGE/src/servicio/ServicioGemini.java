package servicio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioGemini {
  //  private final String API_KEY = "AIzaSyBThPsBc75BawkXETUbqrvH14Bwz9hJfmM";
	private final String API_KEY = "";
    private final String URL_BASE = "https://generativelanguage.googleapis.com/v1beta/models/gemini-flash-latest:generateContent";

    public String obtenerRespuesta(String mensajeUsuario) {
        try {
            String mensajeLimpio = mensajeUsuario.replace("\"", "\\\"").replace("\n", " ");
            String jsonBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + mensajeLimpio + "\"}]}]}";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_BASE))
                    .header("Content-Type", "application/json")
                    .header("X-goog-api-key", API_KEY) 
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return extraerRespuesta(response.body());
            } else {
                System.out.println("Error: " + response.body());
                return "Error " + response.statusCode();
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    private String extraerRespuesta(String jsonCompleto) {
        try {
            int inicio = jsonCompleto.indexOf("\"text\": \"") + 9;
            int fin = jsonCompleto.indexOf("\"", inicio);
            String texto = jsonCompleto.substring(inicio, fin);
            return texto.replace("\\n", "\n"); 
        } catch (Exception e) {
            return "No se pudo procesar la respuesta de la IA.";
        }
    }
}
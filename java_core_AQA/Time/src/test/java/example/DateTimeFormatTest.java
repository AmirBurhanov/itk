package example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DateTimeFormatTest {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("=== Testing DateTime Formatting ===\n");

        // Тест основного эндпоинта
        System.out.println("1. Testing /format endpoint:");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/time/format"))
                .header("Accept-Language", "ru")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
        System.out.println("Status: " + response.statusCode());

        // Анализ результата
        if (response.statusCode() == 200) {
            System.out.println("\n✅ SUCCESS! DateTime formatted in pattern: yyyy:MM:dd##HH:mm:ss:SSS");
            System.out.println("Check that the response contains formatted date like: 2025:10:15##12:30:45:123");
        }
    }
}
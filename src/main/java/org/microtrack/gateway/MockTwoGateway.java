package org.microtrack.gateway;

import org.microtrack.dto.ResponseTrace;
import org.microtrack.model.dto.MockOneBodyDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MockTwoGateway {

    public String callMockTwo(MockOneBodyDTO dto) throws IOException, InterruptedException {
        try {

            String uri = "http://localhost:8081/mock-two";

            System.out.println(uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(dto.getAllString()))
                    .build();

            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body().toString();

        } catch (Exception exception) {
            System.out.print("Erro ao enviar trace para o serviço central!");
            throw exception;
        }

    }

}

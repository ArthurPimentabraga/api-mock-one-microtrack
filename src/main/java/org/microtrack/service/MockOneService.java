package org.microtrack.service;

import lombok.AllArgsConstructor;
import org.microtrack.dto.ResponseTrace;
import org.microtrack.dto.Trace;
import org.microtrack.gateway.MockTwoGateway;
import org.microtrack.model.dto.ProductDTO;
import org.microtrack.model.enums.StatusProductEnum;

import java.io.IOException;
import java.sql.Timestamp;

@AllArgsConstructor
public class MockOneService {

    public void buyProduct(ProductDTO body) throws IOException, InterruptedException {
        // TODO Criar Beans para cada objeto singleton
        Manager manager = new Manager(true);
        TraceService traceService = new TraceService();

        ProductDTO product = updateStatus(body);

        traceRegister(body, product, traceService, manager);

        callMockTwo(product);
    }

    public ProductDTO updateStatus(ProductDTO productDTO) {
        productDTO.setStatus(StatusProductEnum.REQUESTED);
        return productDTO;
    }

    private static void traceRegister(ProductDTO body, ProductDTO product, TraceService traceService, Manager manager) throws IOException, InterruptedException {
        Trace trace = Trace.builder()
                .traceId(body.getId())
                .serviceName("api-mock-one-microtrack")
                .checkpointName("solicitacao-compra-recebida")
                .isError(Boolean.FALSE)
                .genericData(product)
                .build();

        ResponseTrace response = traceService.checkpoint(manager, trace);

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Message: " + response.getMessage());
    }

    private static void callMockTwo(ProductDTO product) throws IOException, InterruptedException {
        Thread.sleep(5000);
        MockTwoGateway gateway = new MockTwoGateway();
        String responseGateway = gateway.callMockTwo(product);
        System.out.println("Requisição à API 2: %n" + responseGateway);
    }

}

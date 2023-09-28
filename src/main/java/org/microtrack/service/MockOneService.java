package org.microtrack.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.microtrack.dto.ResponseTrace;
import org.microtrack.dto.Trace;
import org.microtrack.gateway.MockTwoGateway;
import org.microtrack.model.dto.MockOneBodyDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.Timestamp;

@AllArgsConstructor
public class MockOneService {

    public void test(MockOneBodyDTO body) throws IOException, InterruptedException {
        // TODO Criar Beans para cada objeto singleton
        Manager manager = new Manager(true);
        TraceService traceService = new TraceService();

        Trace trace = Trace.builder()
                .traceId(body.getTraceId())
                .serviceName("api-mock-one-microtrack")
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .checkpointName("Test dinâmico")
                .isError(Boolean.FALSE)
                .build();

        ResponseTrace response = traceService.checkpoint(manager, trace);

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Message: " + response.getMessage());

        System.out.println(trace.getAllString()); // TODO Melhorar body

        MockTwoGateway gateway = new MockTwoGateway();
        String responseGateway = gateway.callMockTwo(body);
        System.out.println(responseGateway);
    }
}

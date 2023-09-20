package org.microtrack;

import org.microtrack.dto.Trace;
import org.microtrack.service.Manager;
import org.microtrack.service.TraceService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        Manager manager = new Manager(true);
        TraceService traceService = new TraceService();

        Trace trace = Trace.builder()
                .traceId("Batata1")
                .serviceName("api-mock-one-microtrack")
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .checkpointName("Checkpoint1")
                .isError(Boolean.FALSE)
                .build();

        traceService.checkpoint(manager, trace);

        System.out.println(trace.getAllString());
    }
}

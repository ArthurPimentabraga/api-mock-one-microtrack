package org.microtrack.controller;

import jakarta.validation.Valid;
import org.microtrack.dto.Trace;
import org.microtrack.model.dto.MockOneBodyDTO;
import org.microtrack.service.Manager;
import org.microtrack.service.MockOneService;
import org.microtrack.service.TraceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/mock-one")
public class MockOneController {

    public final MockOneService service = new MockOneService();

    @PostMapping
    public ResponseEntity<String> testOne(@RequestBody @Valid MockOneBodyDTO body) throws IOException, InterruptedException {
        service.test(body);
        return ResponseEntity.ok("Deu certo!");
    }

}

package org.microtrack.controller;

import jakarta.validation.Valid;
import org.microtrack.model.dto.ProductDTO;
import org.microtrack.service.MockOneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/request-purchase-product")
public class MockOneController {

    public final MockOneService service = new MockOneService();

    @PostMapping
    public ResponseEntity<String> buyProduct(@RequestBody @Valid ProductDTO body) {
        try {
            service.buyProduct(body);
            return ResponseEntity.ok("Deu certo!"); // TODO Retorno adequado
        } catch (Exception ex) {
            // TODO add print
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

}

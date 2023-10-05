package org.microtrack.model.dto;

import lombok.*;
import org.microtrack.model.enums.StatusProductEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private String nomeProduto;
    private String descricaoProduto;
    private StatusProductEnum status;

    public String getString() {
        return String.format(
                "{\"id\": \"%s\", \"nomeProduto\": \"%s\", \"descricaoProduto\": \"%s\", \"status\": \"%s\"}",
                id, nomeProduto, descricaoProduto, status
        );
    }

}
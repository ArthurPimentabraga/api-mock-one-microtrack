package org.microtrack.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MockOneBodyDTO {

    private String traceId;

    public String getAllString() {
        return String.format(
                "{\"traceId\": \"%s\"}",
                traceId
        );
    }

}
package com.prajwal.api_gateway.filter.record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationResponse {

    private String message;
    private Boolean isValid;

    // getters and setters

}

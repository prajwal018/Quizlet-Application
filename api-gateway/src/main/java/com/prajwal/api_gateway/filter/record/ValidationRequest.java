package com.prajwal.api_gateway.filter.record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationRequest {

    private String jwt;
    // getters and setters

}

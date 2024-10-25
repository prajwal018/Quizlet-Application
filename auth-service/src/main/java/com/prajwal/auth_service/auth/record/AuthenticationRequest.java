package com.prajwal.auth_service.auth.record;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;

    // getters and setters
}

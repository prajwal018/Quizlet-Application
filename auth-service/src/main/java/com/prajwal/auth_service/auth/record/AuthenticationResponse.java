package com.prajwal.auth_service.auth.record;

import com.prajwal.auth_service.auth.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String message;
    private String firstname;
    private String lastname;
    private String username;
    private String token;
    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN or USER
}

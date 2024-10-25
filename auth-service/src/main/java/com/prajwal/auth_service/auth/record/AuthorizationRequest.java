package com.prajwal.auth_service.auth.record;

import com.prajwal.auth_service.auth.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Role role;
}

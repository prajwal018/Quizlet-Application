package com.prajwal.api_gateway.filter.service;

import com.prajwal.api_gateway.filter.client.AuthClient;
import com.prajwal.api_gateway.filter.record.ValidationRequest;
import com.prajwal.api_gateway.filter.record.ValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthClient authClient;

    public ResponseEntity<ValidationResponse> validateUser(ValidationRequest request) {
        return ResponseEntity.ok(authClient.validateUser(request));
    }
}

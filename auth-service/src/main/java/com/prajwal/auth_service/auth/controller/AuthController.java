package com.prajwal.auth_service.auth.controller;

import com.prajwal.auth_service.auth.record.*;
import com.prajwal.auth_service.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationService service;

    @PostMapping("signup")
    public ResponseEntity<AuthorizationResponse> authorizeUser(@RequestBody AuthorizationRequest authorizationRequest) {
        return ResponseEntity.ok(service.authorize(authorizationRequest));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return ResponseEntity.ok(service.authenticate(authenticationRequest));
    }

    @PostMapping("validate")
    public ResponseEntity<ValidationResponse> validateUser(@RequestBody ValidationRequest validationRequest) throws Exception {
        return ResponseEntity.ok(service.validate(validationRequest));
    }


}

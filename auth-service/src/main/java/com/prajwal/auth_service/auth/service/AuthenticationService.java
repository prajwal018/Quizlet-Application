package com.prajwal.auth_service.auth.service;

import com.prajwal.auth_service.auth.model.User;
import com.prajwal.auth_service.auth.record.*;
import com.prajwal.auth_service.auth.repository.UserRepository;
import com.prajwal.auth_service.auth.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthorizationResponse authorize(AuthorizationRequest request) {
        Optional<User> exUser = repository.findByUsername(request.getUsername());

        if (exUser.isPresent() && exUser.get().getUsername().equals(request.getUsername())) {
            throw new UsernameNotFoundException("User exists already");
        }
//        String hashedApiKey=null;
//        String hashedApiKey = null;
//        if (request.getRole() == Role.ADMIN) {
//            String rawApiKey = ApiKeyUtil.generateApiKey();
//            hashedApiKey = ApiKeyUtil.hashApiKey(rawApiKey);
//        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
//                .apiKey(hashedApiKey)
                .build();

        repository.save(user);
//        var jwtToken = jwtUtil.generateToken(user);
        return AuthorizationResponse.builder()
                .message("User registration successful")
//                .apikey(hashedApiKey)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        if (authentication.isAuthenticated()) {
            var user = repository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("Invalid credentials"));
            var jwtToken = jwtUtil.generateToken(user);
            return AuthenticationResponse.builder()
                    .message("Login successful")
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .role(user.getRole())
                    .token(jwtToken)
                    .build();
        } else
            throw new RuntimeException("Invalid credentials");
    }

    public ValidationResponse validate(ValidationRequest request) {
        var username = jwtUtil.extractUsername(request.getJwt());
        var user = repository.findByUsername(username).get();
        return ValidationResponse.builder()
                .message("The User is valid user ")
                .isValid(jwtUtil.isTokenValid(request.getJwt(), user))
                .build();

    }
}

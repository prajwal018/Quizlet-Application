package com.prajwal.api_gateway.filter.client;


import com.prajwal.api_gateway.filter.record.ValidationRequest;
import com.prajwal.api_gateway.filter.record.ValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class AuthClient {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${application.config.auth-url}")
    private String authUrl;

    public ValidationResponse validateUser(ValidationRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<ValidationRequest> requestEntity = new HttpEntity<>(request, headers);
        ParameterizedTypeReference<ValidationResponse> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<ValidationResponse> responseEntity = restTemplate.exchange(authUrl + "validate", POST, requestEntity, responseType);

        if (responseEntity.getStatusCode().isError())
            throw new RuntimeException("An Error occured while validating user" + responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

}

package com.prajwal.api_gateway.filter;

import com.prajwal.api_gateway.filter.record.ValidationRequest;
import com.prajwal.api_gateway.filter.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private AuthService authService;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                //header contains token or not the
                if (exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                    if (authHeader != null && authHeader.startsWith("Bearer ")) {
                        authHeader = authHeader.substring(7);
                    }
                    try {

                        authService.validateUser(ValidationRequest.builder().jwt(authHeader).build());

                        //REST call to AUTH service
//                        template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
//                        jwtUtil.validateToken(authHeader);

                    } catch (Exception e) {
                        System.out.println("invalid access...!");
                        throw new RuntimeException("un authorized access to application");
                    }
                } else {
                    throw new RuntimeException("Missing Authorization Token header");
                }
            }
            return chain.filter(exchange);
        }));
    }

    public static class Config {

    }
}

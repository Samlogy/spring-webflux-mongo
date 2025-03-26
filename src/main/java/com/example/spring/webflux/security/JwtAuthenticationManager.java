package com.example.spring.webflux.security;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationManager(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();

        if (jwtUtil.validateToken(authToken)) {
            String username = jwtUtil.getUsernameFromJWT(authToken);
            // Create an authentication token with no roles for simplicity.
            Authentication auth = new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
            return Mono.just(auth);
        } else {
            return Mono.empty();
        }
    }
}

package com.example.spring.webflux.security;

import com.example.spring.webflux.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Simulated login endpoint. In a real app, verify username/password.
    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestParam String username, @RequestParam String password) {
        // For demo: any username/password is accepted.
        String token = jwtUtil.generateToken(username);
        return Mono.just(ResponseEntity.ok(token));
    }
}

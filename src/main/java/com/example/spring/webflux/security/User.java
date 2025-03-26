package com.example.spring.webflux.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    // Role values could be "USER", "MODERATOR", or "ADMIN"
    private String role;
}

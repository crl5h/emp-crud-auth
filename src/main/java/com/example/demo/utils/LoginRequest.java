package com.example.demo.utils;

import lombok.Builder;
import lombok.Getter;

// login request type
@Getter
@Builder
public class LoginRequest {
    private Long uid;
    private String email;
    private String password;
}

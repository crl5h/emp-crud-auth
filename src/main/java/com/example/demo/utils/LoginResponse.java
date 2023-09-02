package com.example.demo.utils;


import lombok.Builder;
import lombok.Getter;

// login response type
@Getter
@Builder
public class LoginResponse {
    private final String accessToken;
}

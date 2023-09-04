package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.security.JwtIssuer;
import com.example.demo.service.UserService;
import com.example.demo.utils.LoginRequest;
import com.example.demo.utils.LoginResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@RestController
@RequiredArgsConstructor // makes a constructor for final fields
@RequestMapping("/auth")
public class AuthController {

    private final JwtIssuer jwtIssuer;

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest request) {
        UserEntity user = userService.findUserFromDb(request.getEmail());
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtIssuer.issue(user.getId(), user.getEmail(), List.of(user.getRole()));

        return ResponseEntity.ok(LoginResponse.builder().accessToken(token).build());
    }

    @PostMapping("/auth/signup")
    public void signup() {

    }
}

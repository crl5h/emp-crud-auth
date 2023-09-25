package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import com.example.demo.utils.LoginRequest;
import com.example.demo.utils.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@RestController
@RequiredArgsConstructor // makes a constructor for final fields
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest request) {
        return authService.loginUser(request.getEmail(), request.getPassword());
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User userEntity) {
        String password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        userRepository.save(userEntity);
    }
}

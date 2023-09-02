package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.security.JwtIssuer;
import com.example.demo.service.UserService;
import com.example.demo.utils.LoginRequest;
import com.example.demo.utils.LoginResponse;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor // makes a constructor for final fields
@RequestMapping("/auth")
public class AuthController {
    private final JwtIssuer jwtIssuer;
    @Autowired
    private UserRepository userRepository;

//    public AuthController(JwtIssuer jwtIssuer) {
//        this.jwtIssuer = jwtIssuer;
//    }
    @Autowired
    private final UserService userService;

    @PostMapping ("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        UserEntity user = userService.findByEmail(request.getEmail());
        String token = jwtIssuer.issue(request.getUid(), request.getEmail(),List.of("USER"));
//        String token = jwtIssuer.issue(request.getEmail(),List.of("USER"));

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

    @PostMapping("/auth/signup")
    public void signup(){

    }
}

package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.security.JwtIssuer;
import com.example.demo.utils.LoginResponse;
import com.example.demo.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@RestController
public class AuthController {
    private final JwtIssuer jwtIssuer;
    private UserRepository userRepository;

    public AuthController(JwtIssuer jwtIssuer) {
        this.jwtIssuer = jwtIssuer;
    }

    @PostMapping ("/auth/login")
    public LoginResponse login(@RequestBody @Validated UserEntity request){

        String email = request.getEmail();
        String pass = request.getPassword();

        System.out.println(request.getUid()+" "+email+" "+pass);

        String token = jwtIssuer.issue(request.getUid(), request.getEmail(),List.of("USER"));

        return new LoginResponse(token);
    }

    @GetMapping("/auth/test")
    public String test(){
        return "test";
    }

    @PostMapping("/auth/signup")
    public void signup(){

    }
}

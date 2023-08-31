package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewTestController {
    @GetMapping("/m")
    public String f(){
        System.out.println("Here");return "WORKS";}
}

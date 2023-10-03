package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    // entity used : "USER"
    // permissions: ["CREATE@USER", "DELETE@USER", "VIEW@USER"]

    @PostMapping("/create")
    @PreAuthorize("hasPermission('', 'USER', 'CREATE@USER')")
    public String createUser() {
        return "User Created";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasPermission('', 'USER', 'DELETE@USER')")
    public String deleteUser(@PathVariable("id") int id) {
        return "User Deleted";
    }

    @GetMapping("/view/{id}")
    @PreAuthorize("hasPermission('','EMPLOYEE','CREATE@USER') or hasPermission('','EMPLOYEE','VIEW@USER')")
    public String viewUser(@PathVariable("id") int id) {
        return "user "+id+" viewed";
    }
}
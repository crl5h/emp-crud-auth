package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/user")
public class UserController {
    // entity used : "USER"
    // permissions: ["USER_CREATE", "USER_DELETE", "USER_VIEW"]

    @PostMapping("/create")
    @PreAuthorize("hasPermission('', 'USER', 'USER_CREATE')")
    public String createUser() {
        return "User Created";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasPermission('', 'USER', 'USER_DELETE')")
    public String deleteUser(@PathVariable("id") int id) {
        return "User Deleted";
    }

    @GetMapping("/view/{id}")
    @PreAuthorize("hasPermission(id, 'USER', 'USER_VIEW')")
    public String viewUser(@PathVariable("id") int id) {
        return "user "+id+" viewed";
    }
}
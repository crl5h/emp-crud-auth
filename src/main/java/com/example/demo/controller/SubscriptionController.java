package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sub")
public class SubscriptionController {
    // entity used : "SUBSCRIPTION"
    // permissions: ["CREATE@SUBSCRIPTION", "DELETE@SUBSCRIPTION", "VIEW@SUBSCRIPTION"]
    @PostMapping("/create")
    @PreAuthorize("hasPermission('', 'SUBSCRIPTION', 'CREATE@SUBSCRIPTION')")
    public String createSubscription() {
        return "subscription created";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasPermission('', 'SUBSCRIPTION', 'DELETE@SUBSCRIPTION')")
    public String deleteSubscription(@PathVariable("id") int id) {
        return "Subscription Deleted";
    }

    @GetMapping("/view")
    @PreAuthorize("hasPermission('', 'SUBSCRIPTION', 'VIEW@SUBSCRIPTION')")
    public String viewSubscription() {
        return "Subscription viewed";
    }
}
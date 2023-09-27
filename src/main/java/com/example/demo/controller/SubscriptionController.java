package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/sub")
public class SubscriptionController {
    // entity used : "SUBSCRIPTION"
    // permissions: ["SUBSCRIPTION_CREATE", "SUBSCRIPTION_DELETE", "SUBSCRIPTION_VIEW"]
    @PostMapping("/create")
    @PreAuthorize("hasPermission('', 'SUBSCRIPTION', 'SUBSCRIPTION_CREATE')")
    public String createSubscription() {
        return "subscription created";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasPermission(id, 'SUBSCRIPTION', 'SUBSCRIPTION_DELETE')")
    public String deleteSubscription(@PathVariable("id") int id) {
        return "Subscription Deleted";
    }

    @GetMapping("/view")
    @PreAuthorize("hasPermission('', 'SUBSCRIPTION', 'SUBSCRIPTION_VIEW')")
    public String viewSubscription() {
        return "Subscription viewed";
    }
}
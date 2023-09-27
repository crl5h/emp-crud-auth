package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/dnd")
public class DndController {

    @PostMapping("/create")
    @PreAuthorize("hasPermission('', 'DND', 'DND_CREATE')")
    public String createDnd() {
        return "dnd created";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasPermission(id, 'DND', 'DND_DELETE')")
    public String deleteDnd(@PathVariable("id") int id) {
        return "dnd deleted";
    }

    @GetMapping("/view")
    @PreAuthorize("hasPermission('', 'DND', 'DND_VIEW')")
    public String viewDnd() {
        return "dnd_viewed";
    }
}
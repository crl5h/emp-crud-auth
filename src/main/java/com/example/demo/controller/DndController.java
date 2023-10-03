package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dnd")
public class DndController {

    @PostMapping("/create")
    @PreAuthorize("hasPermission('', 'DND', 'CREATE@DND')")
    public String createDnd() {
        return "dnd created";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasPermission('', 'DND', 'DELETE@DND')")
    public String deleteDnd(@PathVariable("id") int id) {
        return "dnd deleted";
    }

    @GetMapping("/view")
    @PreAuthorize("hasPermission('', 'DND', 'VIEW@DND') or hasPermission('', 'DND', 'CREATE@DND')")
    public String viewDnd() {
        return "dnd_viewed";
    }
}
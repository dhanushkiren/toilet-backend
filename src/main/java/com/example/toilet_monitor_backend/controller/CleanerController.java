// controller/CleanerController.java
package com.example.toilet_monitor_backend.controller;

import com.example.toilet_monitor_backend.dto.cleaner.CleanerLoginRequest;
import com.example.toilet_monitor_backend.dto.cleaner.CleanerLoginResponse;
import com.example.toilet_monitor_backend.dto.cleaner.CreateCleanerRequest;
import com.example.toilet_monitor_backend.dto.cleaner.CleanerResponse;
import com.example.toilet_monitor_backend.entity.Cleaner;
import com.example.toilet_monitor_backend.service.CleanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cleaners")
@RequiredArgsConstructor
public class CleanerController {
    private final CleanerService service;

    @PostMapping("/login")
    public CleanerLoginResponse login(@RequestBody CleanerLoginRequest req) {
        Cleaner c = service.login(req.getUsername(), req.getPassword());
        return new CleanerLoginResponse(c.getId(), c.getUsername(), c.getFullName());
    }

    @PostMapping("/create")
    public CleanerResponse create(@RequestBody CreateCleanerRequest req) {
        return service.createCleaner(req);
    }

    @GetMapping
    public List<CleanerResponse> list() {
        return service.listCleaners();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteCleaner(id);
        return ResponseEntity.status(200).body("Cleaner Deleted Successfully...");
    }
}

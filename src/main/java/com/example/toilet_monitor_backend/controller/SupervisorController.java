// controller/SupervisorController.java
package com.example.toilet_monitor_backend.controller;

import com.example.toilet_monitor_backend.dto.supervisor.RegisterSupervisorRequest;
import com.example.toilet_monitor_backend.dto.supervisor.SupervisorLoginRequest;
import com.example.toilet_monitor_backend.dto.supervisor.SupervisorLoginResponse;
import com.example.toilet_monitor_backend.dto.supervisor.SupervisorResponse;
import com.example.toilet_monitor_backend.entity.Supervisor;
import com.example.toilet_monitor_backend.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisors")
@RequiredArgsConstructor
public class SupervisorController {
    private final SupervisorService service;

    // ✅ Register API
    @PostMapping("/register")
    public SupervisorResponse register(@RequestBody RegisterSupervisorRequest req) {
        return service.register(req);
    }

    // ✅ Login API
    @PostMapping("/login")
    public SupervisorLoginResponse login(@RequestBody SupervisorLoginRequest req) {
        return service.login(req);
    }

    @GetMapping("/{id}")
    public SupervisorResponse getOne(@PathVariable Long id) {
        return service.getSupervisor(id);
    }

    @GetMapping
    public List<SupervisorResponse> listAll() {
        return service.listAll();
    }
}

// service/SupervisorService.java
package com.example.toilet_monitor_backend.service;

import com.example.toilet_monitor_backend.dto.supervisor.RegisterSupervisorRequest;
import com.example.toilet_monitor_backend.dto.supervisor.SupervisorLoginRequest;
import com.example.toilet_monitor_backend.dto.supervisor.SupervisorLoginResponse;
import com.example.toilet_monitor_backend.dto.supervisor.SupervisorResponse;
import com.example.toilet_monitor_backend.entity.Supervisor;
import com.example.toilet_monitor_backend.repository.SupervisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupervisorService {
    private final SupervisorRepository repo;

    // ✅ Register Supervisor
    public SupervisorResponse register(RegisterSupervisorRequest req) {
        Supervisor supervisor = Supervisor.builder()
                .username(req.getUsername())
                .password(req.getPassword()) // ⚠️ plain text for now (later use BCrypt)
                .fullName(req.getFullName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .build();
        Supervisor saved = repo.save(supervisor);
        return new SupervisorResponse(
                saved.getId(), saved.getUsername(),
                saved.getFullName(), saved.getPhone(),
                saved.getEmail()
        );
    }

    // ✅ Login Supervisor
    public SupervisorLoginResponse login(SupervisorLoginRequest req) {
        Supervisor sup = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Supervisor not found"));

        if (!sup.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new SupervisorLoginResponse(
                sup.getId(),
                sup.getUsername(),
                sup.getFullName(),
                sup.getPhone(),
                sup.getEmail(),
                "Login Successful"
        );
    }


    public SupervisorResponse getSupervisor(Long id) {
        Supervisor sup = repo.findById(id).orElseThrow();
        return new SupervisorResponse(sup.getId(), sup.getUsername(), sup.getFullName(),sup.getPhone(), sup.getEmail());
    }

    public List<SupervisorResponse> listAll() {
        return repo.findAll().stream()
                .map(sup -> new SupervisorResponse(
                        sup.getId(),
                        sup.getUsername(),
                        sup.getFullName(),
                        sup.getPhone(),
                        sup.getEmail()
                ))
                .toList();
    }
}

// service/CleanerService.java
package com.example.toilet_monitor_backend.service;

import com.example.toilet_monitor_backend.dto.cleaner.CreateCleanerRequest;
import com.example.toilet_monitor_backend.dto.cleaner.CleanerResponse;
import com.example.toilet_monitor_backend.entity.Cleaner;
import com.example.toilet_monitor_backend.repository.CleanerRepository;
import com.example.toilet_monitor_backend.repository.SupervisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CleanerService {
    private final CleanerRepository repo;
    private final SupervisorRepository supervisorRepo;   // NEW
    private final PasswordEncoder encoder;

    public Cleaner login(String username, String password) {
        Cleaner c = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Cleaner not found"));

        if (!encoder.matches(password, c.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return c;
    }

    public CleanerResponse createCleaner(CreateCleanerRequest req) {
        var supervisor = supervisorRepo.findById(req.getSupervisorId())
                .orElseThrow(() -> new RuntimeException("Supervisor not found"));

        Cleaner c = Cleaner.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .supervisor(supervisor) // bind supervisor
                .build();

        Cleaner saved = repo.save(c);
        return new CleanerResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getFullName(),
                saved.getPhone(),
                saved.getEmail()
        );
    }

    public List<CleanerResponse> listCleaners() {
        return repo.findAll().stream()
                .map(c -> new CleanerResponse(
                        c.getId(),
                        c.getUsername(),
                        c.getFullName(),
                        c.getPhone(),
                        c.getEmail()
                ))
                .toList();
    }

    public void deleteCleaner(Long id) {
        repo.deleteById(id);
    }
}

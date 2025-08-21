package com.example.toilet_monitor_backend.service;

import com.example.toilet_monitor_backend.dto.auth.LoginRequest;
import com.example.toilet_monitor_backend.dto.auth.LoginResponse;
import com.example.toilet_monitor_backend.dto.auth.RegisterRequest;
import com.example.toilet_monitor_backend.dto.auth.RegisterResponse;
import com.example.toilet_monitor_backend.entity.User;
import com.example.toilet_monitor_backend.repository.UserRepository;
import com.example.toilet_monitor_backend.security.JwtService;
import com.example.toilet_monitor_backend.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public LoginResponse login(LoginRequest req) {
        User user = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwt.generate(user.getId(), user.getUsername(), user.getRole());
        return new LoginResponse(token, user.getId(), user.getRole(), user.getFullName());
    }

    public RegisterResponse register(RegisterRequest req) {
        if (repo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        User user = User.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .role(req.getRole() != null ? req.getRole() : Role.CLEANER) // default CLEANER
                .build();

        User saved = repo.save(user);

        return new RegisterResponse("User registered successfully", saved.getId());
    }
}

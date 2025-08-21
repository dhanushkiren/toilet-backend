package com.example.toilet_monitor_backend.dto.auth;

import com.example.toilet_monitor_backend.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginResponse {
    private String token;
    private Long userId;
    private Role role;    // frontend routes by this
    private String fullName;
}
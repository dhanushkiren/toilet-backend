package com.example.toilet_monitor_backend.dto.auth;

import com.example.toilet_monitor_backend.utils.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @Email
    private String email;

    private String phone;

    private Role role; // optional: if you allow choosing role, otherwise default CLEANER for example
}

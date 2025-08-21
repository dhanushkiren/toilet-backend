package com.example.toilet_monitor_backend.dto.cleaner;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCleanerRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String fullName;
    private String phone;
    private String email;
    private Long supervisorId;
}


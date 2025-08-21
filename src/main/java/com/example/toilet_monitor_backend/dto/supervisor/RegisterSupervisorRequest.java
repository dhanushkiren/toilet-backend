package com.example.toilet_monitor_backend.dto.supervisor;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSupervisorRequest {
    @NotBlank private String username;
    @NotBlank private String password;
    private String fullName;
    private String phone;
    private String email;
}
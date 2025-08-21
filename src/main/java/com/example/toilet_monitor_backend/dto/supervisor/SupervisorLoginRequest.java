package com.example.toilet_monitor_backend.dto.supervisor;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorLoginRequest {
    @NotBlank private String username;
    @NotBlank private String password;
}


package com.example.toilet_monitor_backend.dto.supervisor;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorResponse {
    private Long id;
    private String username;
    private String fullName;
    private String phone;
    private String email;
}
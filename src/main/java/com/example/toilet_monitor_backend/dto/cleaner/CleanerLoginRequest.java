package com.example.toilet_monitor_backend.dto.cleaner;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleanerLoginRequest {
    private String username;
    private String password;
}

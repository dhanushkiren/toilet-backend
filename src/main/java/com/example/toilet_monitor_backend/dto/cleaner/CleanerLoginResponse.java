package com.example.toilet_monitor_backend.dto.cleaner;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleanerLoginResponse {
    private Long id;
    private String username;
    private String fullName;
}

package com.example.toilet_monitor_backend.dto.cleaner;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleanerResponse {
    private Long id;
    private String username;
    private String fullName;
    private String phone;
    private String email;

    public CleanerResponse(Long id, String username, String fullName, String phone) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.phone = phone;
    }
}
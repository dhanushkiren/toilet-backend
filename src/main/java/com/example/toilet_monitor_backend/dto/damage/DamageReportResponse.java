package com.example.toilet_monitor_backend.dto.damage;

import lombok.Data;

@Data
public class DamageReportResponse {
    private Long id;
    private Long toiletId;
    private Long cleanerId;
    private String description;
    private String status; // OPEN, RESOLVED
}
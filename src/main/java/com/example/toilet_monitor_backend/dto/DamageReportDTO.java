package com.example.toilet_monitor_backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class DamageReportDTO {
    private String description;
    private List<String> imageUrls;
}

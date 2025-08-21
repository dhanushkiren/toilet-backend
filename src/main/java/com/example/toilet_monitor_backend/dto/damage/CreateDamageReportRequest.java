package com.example.toilet_monitor_backend.dto.damage;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateDamageReportRequest {
    private Long toiletId;
    private Long cleanerId;
    @NotBlank private String description;
    private List<String> imageUrls;
}
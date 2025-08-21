package com.example.toilet_monitor_backend.dto.inventory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateInventoryRequest {
    private Long toiletId;     // Which toilet the request belongs to
    private Long cleanerId;    // Who raised the request
    @NotBlank private String itemName;
    private int quantity;
    private String description;
}
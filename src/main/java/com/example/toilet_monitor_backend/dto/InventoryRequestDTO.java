package com.example.toilet_monitor_backend.dto;

import lombok.Data;

@Data
public class InventoryRequestDTO {
    private String itemName;
    private int quantity;
    private String description;
}


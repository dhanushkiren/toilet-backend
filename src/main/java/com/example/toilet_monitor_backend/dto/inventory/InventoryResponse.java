package com.example.toilet_monitor_backend.dto.inventory;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long id;
    private Long toiletId;
    private Long cleanerId;
    private String itemName;
    private int quantity;
    private String status; // PENDING, APPROVED, DECLINED
}
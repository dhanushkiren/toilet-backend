// controller/InventoryRequestController.java
package com.example.toilet_monitor_backend.controller;

import com.example.toilet_monitor_backend.dto.inventory.CreateInventoryRequest;
import com.example.toilet_monitor_backend.entity.InventoryRequest;
import com.example.toilet_monitor_backend.service.InventoryRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-requests")
@RequiredArgsConstructor
public class InventoryRequestController {
    private final InventoryRequestService service;

    @PostMapping
    public InventoryRequest create(@RequestBody CreateInventoryRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<InventoryRequest> list() {
        return service.listAll();
    }

    @PutMapping("/{id}/status")
    public InventoryRequest updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}

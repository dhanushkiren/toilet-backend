// controller/DamageReportController.java
package com.example.toilet_monitor_backend.controller;

import com.example.toilet_monitor_backend.dto.damage.CreateDamageReportRequest;
import com.example.toilet_monitor_backend.entity.DamageReport;
import com.example.toilet_monitor_backend.service.DamageReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/damage-reports")
@RequiredArgsConstructor
public class DamageReportController {
    private final DamageReportService service;

    @PostMapping
    public DamageReport create(@RequestBody CreateDamageReportRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<DamageReport> list() {
        return service.listAll();
    }
}

// service/DamageReportService.java
package com.example.toilet_monitor_backend.service;

import com.example.toilet_monitor_backend.dto.damage.CreateDamageReportRequest;
import com.example.toilet_monitor_backend.entity.Cleaner;
import com.example.toilet_monitor_backend.entity.DamageReport;
import com.example.toilet_monitor_backend.repository.CleanerRepository;
import com.example.toilet_monitor_backend.repository.DamageReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DamageReportService {
    private final DamageReportRepository repo;
    private final CleanerRepository cleanerRepo;

    public DamageReport create(CreateDamageReportRequest dto) {
        Cleaner cleaner = cleanerRepo.findById(dto.getCleanerId()).orElseThrow();
        DamageReport report = DamageReport.builder()
                .toiletId(dto.getToiletId())
                .description(dto.getDescription())
                .imageUrls(dto.getImageUrls())
                .reportedBy(cleaner)
                .build();
        return repo.save(report);
    }

    public List<DamageReport> listAll() {
        return repo.findAll();
    }
}

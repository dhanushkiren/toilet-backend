// service/InventoryRequestService.java
package com.example.toilet_monitor_backend.service;

import com.example.toilet_monitor_backend.dto.inventory.CreateInventoryRequest;
import com.example.toilet_monitor_backend.entity.Cleaner;
import com.example.toilet_monitor_backend.entity.InventoryRequest;
import com.example.toilet_monitor_backend.repository.CleanerRepository;
import com.example.toilet_monitor_backend.repository.InventoryRequestRepository;
import com.example.toilet_monitor_backend.utils.RequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryRequestService {
    private final InventoryRequestRepository repo;
    private final CleanerRepository cleanerRepo;

    public InventoryRequest create(CreateInventoryRequest dto) {
        Cleaner cleaner = cleanerRepo.findById(dto.getCleanerId()).orElseThrow();
        InventoryRequest req = InventoryRequest.builder()
                .toiletId(dto.getToiletId())
                .description(dto.getDescription())
                .status(RequestStatus.valueOf("PENDING"))
                .requestedBy(cleaner)
                .build();
        return repo.save(req);
    }

    public List<InventoryRequest> listAll() {
        return repo.findAll();
    }

    public InventoryRequest updateStatus(Long id, String status) {
        InventoryRequest req = repo.findById(id).orElseThrow();
        req.setStatus(RequestStatus.valueOf(status.toUpperCase()));
        return repo.save(req);
    }
}

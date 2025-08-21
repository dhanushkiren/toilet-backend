package com.example.toilet_monitor_backend.repository;

import com.example.toilet_monitor_backend.entity.InventoryRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRequestRepository extends JpaRepository<InventoryRequest,Long> { }

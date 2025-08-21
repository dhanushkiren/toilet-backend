package com.example.toilet_monitor_backend.repository;

import com.example.toilet_monitor_backend.entity.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
    Optional<Cleaner> findByUsername(String username);
    List<Cleaner> findBySupervisorId(Long supervisorId);
}

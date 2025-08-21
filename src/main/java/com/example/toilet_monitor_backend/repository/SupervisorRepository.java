package com.example.toilet_monitor_backend.repository;

import com.example.toilet_monitor_backend.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
    Optional<Supervisor> findByUsername(String username);
}

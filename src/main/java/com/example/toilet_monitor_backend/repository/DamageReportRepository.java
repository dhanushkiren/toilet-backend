package com.example.toilet_monitor_backend.repository;

import com.example.toilet_monitor_backend.entity.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageReportRepository extends JpaRepository<DamageReport, Long> {}

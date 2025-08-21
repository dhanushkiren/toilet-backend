package com.example.toilet_monitor_backend.repository;



import com.example.toilet_monitor_backend.entity.Toilet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToiletRepository extends JpaRepository<Toilet, Long> { }
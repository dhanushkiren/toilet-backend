package com.example.toilet_monitor_backend.repository;



import com.example.toilet_monitor_backend.entity.ToiletImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToiletImageRepository extends JpaRepository<ToiletImage, Long> { }
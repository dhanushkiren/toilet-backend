package com.example.toilet_monitor_backend.repository;


import com.example.toilet_monitor_backend.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> { }

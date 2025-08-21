package com.example.toilet_monitor_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "damage_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DamageReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long toiletId;   // ✅ Added field

    private String description;

    @ElementCollection
    private List<String> imageUrls; // Store uploaded images

    @ManyToOne
    @JoinColumn(name = "cleaner_id")
    private Cleaner reportedBy;     // ✅ Match service

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}

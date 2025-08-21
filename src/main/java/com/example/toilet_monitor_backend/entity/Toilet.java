package com.example.toilet_monitor_backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="toilets")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Toilet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;

    @Column
    private Double latitude;
    @Column
    private Double longitude;

    // comma-separated or normalize via a table; we normalize below with ToiletGender
    @OneToMany(mappedBy = "toilet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToiletGender> genders = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    // Supervisor (single)
    @ManyToOne
    private User supervisor;

    // Multiple cleaners (many-to-many)
    @ManyToMany
    @JoinTable(name = "toilet_cleaners",
            joinColumns = @JoinColumn(name = "toilet_id"),
            inverseJoinColumns = @JoinColumn(name = "cleaner_id"))
    private List<User> cleaners = new ArrayList<>();

    // Images
    @OneToMany(mappedBy = "toilet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToiletImage> images = new ArrayList<>();

    // Feedback (with rating)
    @OneToMany(mappedBy = "toilet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    @Transient
    public Double getAverageRating() {
        if (feedbacks == null || feedbacks.isEmpty()) return null;
        return feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0);
    }

    public enum Status { ACTIVE, INACTIVE }
}

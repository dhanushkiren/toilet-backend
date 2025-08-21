package com.example.toilet_monitor_backend.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity @Table(name="feedbacks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Toilet toilet;

    @ManyToOne
    private User user; // nullable if anonymous

    @Column(nullable = false)
    private Integer rating; // 1..5

    @Column(columnDefinition = "TEXT")
    private String comment;

    private Instant createdAt = Instant.now();
}

package com.example.toilet_monitor_backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="toilet_images")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ToiletImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Toilet toilet;

    @Column(nullable = false, length = 512)
    private String imageUrl; // store URL/path; swap to LONGBLOB if you need binary
}

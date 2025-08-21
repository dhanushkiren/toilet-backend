package com.example.toilet_monitor_backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="toilet_genders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ToiletGender {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Toilet toilet;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    public enum Gender { MALE, FEMALE, DISABLED, UNISEX }
}

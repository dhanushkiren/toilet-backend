package com.example.toilet_monitor_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cleaners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cleaner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String fullName;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor; // Created by a supervisor
}

package com.example.toilet_monitor_backend.entity;

import com.example.toilet_monitor_backend.utils.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@Table(name = "inventory_requests")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long toiletId;
//    private Long cleanerId;
    private String itemName;
    private int quantity;
    private String description;

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // PENDING, APPROVED, DECLINED

    @ManyToOne
    @JoinColumn(name = "cleaner_id")
    private Cleaner requestedBy;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor reviewedBy;
}


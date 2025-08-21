package com.example.toilet_monitor_backend.service;


import com.example.toilet_monitor_backend.dto.toilet.ToiletSummaryDto;
import com.example.toilet_monitor_backend.entity.Toilet;
import com.example.toilet_monitor_backend.repository.ToiletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class ToiletService {
    private final ToiletRepository repo;

    public List<ToiletSummaryDto> findAll() {
        return repo.findAll().stream().map(this::map).toList();
    }
    public ToiletSummaryDto findOne(Long id) {
        return map(repo.findById(id).orElseThrow());
    }

    private ToiletSummaryDto map(Toilet t) {
        return ToiletSummaryDto.builder()
                .id(t.getId())
                .name(t.getName())
                .address(t.getAddress())
                .latitude(t.getLatitude())
                .longitude(t.getLongitude())
                .genders(t.getGenders().stream().map(g -> g.getGender().name().toLowerCase()).toList())
                .status(t.getStatus().name())
                .supervisorId(t.getSupervisor() != null ? t.getSupervisor().getId() : null)
                .cleanerIds(t.getCleaners().stream().map(c -> c.getId()).toList())
                .imageUrls(t.getImages().stream().map(i -> i.getImageUrl()).toList())
                .averageRating(t.getAverageRating())
                .build();
    }
}
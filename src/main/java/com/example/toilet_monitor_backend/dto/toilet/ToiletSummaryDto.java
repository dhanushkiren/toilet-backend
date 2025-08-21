package com.example.toilet_monitor_backend.dto.toilet;


import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data @Builder
public class ToiletSummaryDto {
    private Long id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private List<String> genders; // ["male","female",...]
    private String status;
    private Long supervisorId;
    private List<Long> cleanerIds;
    private List<String> imageUrls;
    private Double averageRating; // computed
}
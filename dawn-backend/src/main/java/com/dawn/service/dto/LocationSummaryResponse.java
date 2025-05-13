package com.dawn.service.dto;

import com.dawn.domain.Location;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class LocationSummaryResponse {
    private Long id;
    private String name;
    private String nameEng;
    private String locationSimpleImage;
    private String address;
    private List<KeywordSummaryResponse> keywords;

    public static LocationSummaryResponse from(Location location) {
        return LocationSummaryResponse.builder()
                .id(location.getSeq())
                .name(location.getName())
                .nameEng(location.getNameEng())
                .locationSimpleImage(location.getSimpleImage())
                .address(location.getAddress())
                .keywords(location.getKeywords().stream()
                        .map(KeywordSummaryResponse::from)
                        .toList())
                .build();

    }


}

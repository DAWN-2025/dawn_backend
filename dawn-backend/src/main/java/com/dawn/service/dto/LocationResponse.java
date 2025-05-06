package com.dawn.service.dto;

import com.dawn.domain.Location;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class LocationResponse {

    private Long id;
    private String name;
    private String address;
    private String image;
    private String shortInfo;
    private String historicInfo;
    private String etiquette;

    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private String phoneNum;
    private String exhibitionTime;
    private String available;
    private String translate;

    private String nameEng;
    private String addressEng;

    private List<KeywordSummaryResponse> keywords;

    public static LocationResponse from(Location loc) {
        return LocationResponse.builder()
                .id(loc.getSeq())
                .name(loc.getName())
                .address(loc.getAddress())
                .image(loc.getImage())
                .shortInfo(loc.getShortInfo())
                .historicInfo(loc.getHistoricInfo())
                .etiquette(loc.getEtiquette())
                .openTime(loc.getOpenTime())
                .closeTime(loc.getCloseTime())
                .phoneNum(loc.getPhoneNum())
                .exhibitionTime(loc.getExhibitionTIme())  // ← 엔티티에 오타 있어도 맞춰줘야 함
                .available(loc.getAvailable())
                .translate(loc.getTranslate())
                .nameEng(loc.getNameEng())
                .addressEng(loc.getAddressEng())
                .keywords(loc.getKeywords().stream()
                        .map(KeywordSummaryResponse::from)
                        .toList())
                .build();
    }
}
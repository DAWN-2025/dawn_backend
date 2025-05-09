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
    private String event;
    private Long eventId;

    private String openTime;
    private String closeTime;
    private String phoneNum;
    private String exhibitionTime;
    private String available;
    private String translate;

    private String shortInfoEng;
    private String historicInfoEng;
    private String etiquetteEng;
    private String nameEng;
    private String addressEng;

    private List<KeywordSummaryResponse> keywords;

    public static LocationResponse from(Location loc) {
        return LocationResponse.builder()
                .id(loc.getSeq())
                .name(loc.getName())
                .address(loc.getAddress())
                .image(loc.getImage())
                .event(loc.getEvent().getName())
                .eventId(loc.getEvent().getSeq())
                .shortInfo(loc.getShortInfo())
                .shortInfoEng(loc.getShortInfoEng())
                .historicInfo(loc.getHistoricInfo())
                .historicInfoEng(loc.getHistoricInfoEng())
                .etiquette(loc.getEtiquette())
                .etiquetteEng(loc.getEtiquetteEng())
                .openTime(loc.getOpenTime())
                .closeTime(loc.getCloseTime())
                .phoneNum(loc.getPhoneNum())
                .exhibitionTime(loc.getExhibitionTime())
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
package com.dawn.service.dto;

import com.dawn.domain.Event;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class EventDetailResponse {
    private Long id;
    private String name;
    private String shortInfo;
    private String background;
    private String progress;
    private String meaning;
    private LocalDateTime date;
    private String nation;
    private String category;
    private String nameEng;
    private String nationEng;
    private String categoryEng;
    private String image;
    private List<KeywordSummaryResponse> keywords;


    public static EventDetailResponse from(Event event) {
        return EventDetailResponse.builder()
                .id(event.getSeq())
                .name(event.getName())
                .shortInfo(event.getShortInfo())
                .background(event.getBackground())
                .progress(event.getProgress())
                .meaning(event.getMeaning())
                .date(event.getDate())
                .nation(event.getNation())
                .nameEng(event.getNameEng())
                .nationEng(event.getNationEng())
                .image(event.getEventImage())
                .keywords(event.getKeywords().stream()
                        .map(KeywordSummaryResponse::from)
                        .toList())
                .build();
    }

    public static List<EventDetailResponse> from(List<Event> events) {
        return events.stream()
                .map(EventDetailResponse::from)
                .collect(Collectors.toList());
    }
}



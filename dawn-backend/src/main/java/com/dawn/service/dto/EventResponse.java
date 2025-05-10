package com.dawn.service.dto;

import com.dawn.domain.Event;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class EventResponse {
    private Long id;
    private String name;
    private String shortInfo;
    private String background;
    private String progress;
    private String meaning;
    private String shortInfoEng;
    private String backgroundEng;
    private String progressEng;
    private String meaningEng;
    private LocalDateTime date;
    private String nation;
    private String nameEng;
    private String nationEng;
    private String image;
    private List<KeywordSummaryResponse> keywords;


    public static EventResponse from(Event event) {
        return EventResponse.builder()
                .id(event.getSeq())
                .name(event.getName())
                .shortInfo(event.getShortInfo())
                .shortInfoEng(event.getShortInfoEng())
                .background(event.getBackground())
                .backgroundEng(event.getBackgroundEng())
                .progress(event.getProgress())
                .progressEng(event.getProgressEng())
                .meaning(event.getMeaning())
                .meaningEng(event.getMeaningEng())
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

    public static List<EventResponse> from(List<Event> events) {
        return events.stream()
                .map(EventResponse::from)
                .collect(Collectors.toList());
    }
}



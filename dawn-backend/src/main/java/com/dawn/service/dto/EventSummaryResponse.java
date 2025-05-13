package com.dawn.service.dto;

import com.dawn.domain.Event;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EventSummaryResponse {

    private Long id;
    private String name;
    private String nameEng;
    private String eventImage;
    private List<KeywordSummaryResponse> keywords;


    public static EventSummaryResponse from(Event event) {
        return EventSummaryResponse.builder()
                .id(event.getSeq())
                .name(event.getName())
                .nameEng(event.getNameEng())
                .eventImage(event.getEventImage())
                .keywords(event.getKeywords().stream()
                        .map(KeywordSummaryResponse::from)
                        .toList())
                .build();

    }

}

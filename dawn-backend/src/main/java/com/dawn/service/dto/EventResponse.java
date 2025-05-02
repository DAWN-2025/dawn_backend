package com.dawn.service.dto;

import com.dawn.domain.Event;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class EventResponse {
    private Long id;
    private String name;
    private LocalDateTime occurDate;
    private String nation;
    private String category;
    private String nameEng;
    private String nationEng;
    private String categoryEng;
    private String info;

    public static EventResponse from(Event event) {
        return EventResponse.builder()
                .id(event.getSeq())
                .name(event.getName())
                .occurDate(event.getDate())
                .nation(event.getNation())
                .category(event.getCategory())
                .nameEng(event.getNameEng())
                .nationEng(event.getNationEng())
                .categoryEng(event.getCategoryEng())
                .info(event.getInfo())
                .build();
    }
}



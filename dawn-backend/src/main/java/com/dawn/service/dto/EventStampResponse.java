package com.dawn.service.dto;

import com.dawn.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventStampResponse {
    private Long eventSeq;
    private String eventName;
    private String eventNameEng;
    private String eventStampImg;

    public static EventStampResponse from(Event event) {
        return EventStampResponse.builder()
                .eventSeq(event.getSeq())
                .eventName(event.getName())
                .eventNameEng(event.getNameEng())
                .eventStampImg(event.getEventStampImage())
                .build();
    }
}

package com.dawn.service.dto;

import com.dawn.domain.Event;
import com.dawn.domain.Stamp;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EventStampGroupResponse {
    private EventResponse event;
    private List<StampResponse> stamps;

    public static EventStampGroupResponse from(Event event, List<Stamp> stamps) {
        return EventStampGroupResponse.builder()
                .event(EventResponse.from(event))
                .stamps(stamps.stream().map(StampResponse::from).toList())
                .build();
    }
}


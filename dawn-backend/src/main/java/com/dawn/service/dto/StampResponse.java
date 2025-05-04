package com.dawn.service.dto;

import com.dawn.domain.Stamp;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class StampResponse {
    private Long seq;
    private Long locationSeq;
    private Long userSeq;
    private Long eventSeq;
    private LocalDateTime statusTime;
    private String stampImage;

    public static StampResponse from(Stamp stamp) {
        return StampResponse.builder()
                .seq(stamp.getSeq())
                .locationSeq(stamp.getLocation().getSeq())
                .userSeq(stamp.getOwner().getSeq())
                .eventSeq(stamp.getEvent().getSeq())
                .statusTime(stamp.getStatusTime())
                .stampImage(stamp.getStampImage())
                .build();
    }
}
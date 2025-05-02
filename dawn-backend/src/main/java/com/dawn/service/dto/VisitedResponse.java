package com.dawn.service.dto;

import com.dawn.domain.Visited;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VisitedResponse {
    private Long seq;
    private Long userSeq;
    private Long locationSeq;
    private LocalDateTime visitedDate;
    private String comment;
    private int likes;

    public static VisitedResponse from(Visited v) {
        return VisitedResponse.builder()
                .seq(v.getSeq())
                .userSeq(v.getUser().getSeq())
                .locationSeq(v.getLocation().getSeq())
                .visitedDate(v.getVisitedDate())
                .comment(v.getComment())
                .likes(v.getLikes())
                .build();
    }
}

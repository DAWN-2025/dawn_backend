package com.dawn.service.dto;

import com.dawn.domain.Letter;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LetterResponse {
    private Long seq;
    private String userUid;
    private Long locationSeq;
    private String content;
    private LocalDateTime letterTime;

    public static LetterResponse from(Letter letter) {
        return LetterResponse.builder()
                .seq(letter.getSeq())
                .userUid(letter.getUser().getUid())
                .locationSeq(letter.getLocation().getSeq())
                .content(letter.getContent())
                .letterTime(letter.getLetterTime())
                .build();
    }
}
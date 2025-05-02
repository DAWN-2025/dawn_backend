package com.dawn.service.dto;

import com.dawn.domain.Letter;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LetterResponse {
    private Long seq;
    private Long userSeq;
    private Long locationSeq;
    private String content;
    private String stampImg;
    private String markImg;
    private LocalDateTime letterTime;

    public static LetterResponse from(Letter letter) {
        return LetterResponse.builder()
                .seq(letter.getSeq())
                .userSeq(letter.getUser().getSeq())
                .locationSeq(letter.getLocation().getSeq())
                .content(letter.getContent())
                .stampImg(letter.getStampImg())
                .markImg(letter.getMarkImg())
                .letterTime(letter.getLetterTime())
                .build();
    }
}
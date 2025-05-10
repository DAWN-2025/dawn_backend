package com.dawn.service.dto;

import com.dawn.domain.Keyword;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KeywordResponse {
    private Long seq;
    private String keyword;
    private Long eventSeq;
    private Long locationSeq;
    private Integer korEngFlag;

    public static KeywordResponse from(Keyword k) {
        return KeywordResponse.builder()
                .seq(k.getSeq())
                .keyword(k.getKeyword())
                .eventSeq(k.getEvent() != null ? k.getEvent().getSeq() : null)
                .locationSeq(k.getLocation() != null ? k.getLocation().getSeq() : null)
                .korEngFlag(k.getKorEngFlag())
                .build();
    }
}
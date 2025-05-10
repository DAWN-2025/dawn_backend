package com.dawn.service.dto;

import com.dawn.domain.Keyword;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KeywordSummaryResponse {
    private String keyword;
    private String keywordEng;

    public static KeywordSummaryResponse from(Keyword k) {
        return KeywordSummaryResponse.builder()
                .keyword(k.getKeyword())
                .keywordEng(k.getKeywordEng())
                .build();
    }
}
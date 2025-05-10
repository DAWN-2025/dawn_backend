package com.dawn.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateLetterRequest {
    private Long userSeq;
    private Long locationSeq;
    private String content;
    private String stampImg;
    private String markImg;
}
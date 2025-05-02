package com.dawn.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateVisitedRequest {
    private Long userSeq;
    private Long locationSeq;
    private String comment;
}

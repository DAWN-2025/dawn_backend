package com.dawn.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateStampRequest {
    private Long locationSeq;
    private Long userSeq;
}
package com.dawn.service.dto;

import lombok.Getter;

@Getter
public class ChatRequest {
    private String userUid;
    private Long locationSeq;
    private String question;
}
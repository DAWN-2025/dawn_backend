package com.dawn.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveChatRequest {
    private String userUid;
    private Long locSeq;
//    private String chatTarget;
    private String chatQuestion;
    private String chatAnswer;
}

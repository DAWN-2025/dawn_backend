package com.dawn.service.dto;

import com.dawn.domain.Chat;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatResponse {
    private Long chatSeq;
    private String userUid;
    private Long locationSeq;
//    private String chatTarget;
    private String chatQuestion;
    private String chatAnswer;

    public static ChatResponse from(Chat chat) {
        return ChatResponse.builder()
                .chatSeq(chat.getChatSeq())
                .userUid(chat.getUser().getUid())
                .locationSeq(chat.getLocation().getSeq())
//                .chatTarget(chat.getChatTarget())
                .chatQuestion(chat.getChatQuestion())
                .chatAnswer(chat.getChatAnswer())
                .build();
    }

}

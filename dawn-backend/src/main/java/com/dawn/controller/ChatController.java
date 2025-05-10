package com.dawn.controller;

import com.dawn.domain.Chat;
import com.dawn.service.ChatService;
import com.dawn.service.dto.ChatResponse;
import com.dawn.service.dto.LetterResponse;
import com.dawn.service.dto.SaveChatRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@Tag(name = "Chat", description = "챗봇 관련 API")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/saveChat")
    @Operation(summary = "채팅내용 저장", description = "채팅 내용 DB에 저장")
    public ResponseEntity<ChatResponse> saveChat(@RequestBody SaveChatRequest request) {
        Chat chat = chatService.saveChat(request);
        return ResponseEntity.ok(ChatResponse.from(chat));
    }
}

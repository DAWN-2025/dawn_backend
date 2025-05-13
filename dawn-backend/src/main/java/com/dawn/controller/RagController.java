package com.dawn.controller;

import com.dawn.service.RagService;
import com.dawn.service.dto.ChatRequest;
import com.dawn.service.dto.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rag")
public class RagController {
    private final RagService ragService;

    public RagController(RagService ragService) {
        this.ragService = ragService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> rag(@RequestBody ChatRequest request) {
        ChatResponse response = ragService.queryToRag(
                request.getUserUid(),
                request.getLocationSeq(),
                request.getQuestion()
        );
        return ResponseEntity.ok(response);
    }
}
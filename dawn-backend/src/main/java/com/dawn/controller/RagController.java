package com.dawn.controller;

import com.dawn.service.RagService;
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
    public ResponseEntity<ChatResponse> rag(
            @RequestParam Long userSeq,
            @RequestParam Long locationSeq,
//            @RequestParam String chatTarget,
            @RequestParam String question
    ) {
        ChatResponse response = ragService.queryToRag(userSeq, locationSeq, question);
        return ResponseEntity.ok(response);
    }

}

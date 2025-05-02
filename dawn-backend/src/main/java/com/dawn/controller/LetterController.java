package com.dawn.controller;

import com.dawn.domain.Letter;
import com.dawn.service.LetterService;
import com.dawn.service.dto.CreateLetterRequest;
import com.dawn.service.dto.LetterResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letter")
@RequiredArgsConstructor
@Tag(name = "Letter", description = "AI 페르소나 편지 저장/조회 API")
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/create")
    @Operation(summary = "편지 저장", description = "사용자에게 전달된 편지를 저장합니다.")
    public ResponseEntity<LetterResponse> create(@RequestBody CreateLetterRequest request) {
        Letter letter = letterService.create(request);
        return ResponseEntity.ok(LetterResponse.from(letter));
    }

    @GetMapping("/byLocation")
    @Operation(summary = "장소 기준 편지 조회", description = "특정 장소에서 생성된 모든 편지를 조회합니다.")
    public ResponseEntity<List<LetterResponse>> byLocation(@RequestParam Long locationSeq) {
        List<LetterResponse> result = letterService.getByLocation(locationSeq).stream()
                .map(LetterResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/byUser")
    @Operation(summary = "사용자 기준 편지 조회", description = "특정 사용자가 받은 모든 편지를 조회합니다.")
    public ResponseEntity<List<LetterResponse>> byUser(@RequestParam Long userSeq) {
        List<LetterResponse> result = letterService.getByUser(userSeq).stream()
                .map(LetterResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }
}
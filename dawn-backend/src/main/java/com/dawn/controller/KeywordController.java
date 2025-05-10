package com.dawn.controller;


import com.dawn.service.KeywordService;
import com.dawn.service.dto.KeywordResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/keyword")
@RequiredArgsConstructor
@Tag(name = "Keyword", description = "장소 관련 키워드 API")
public class KeywordController {

    private final KeywordService keywordService;

    @GetMapping("/byLocation")
    @Operation(summary = "장소 기준 키워드 조회", description = "특정 장소에 연결된 키워드 목록을 조회합니다.")
    public ResponseEntity<List<KeywordResponse>> getByLocation(@RequestParam Long locationSeq) {
        List<KeywordResponse> result = keywordService.getByLocation(locationSeq).stream()
                .map(KeywordResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }
}

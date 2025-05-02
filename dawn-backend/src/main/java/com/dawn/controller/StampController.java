package com.dawn.controller;

import com.dawn.domain.Stamp;
import com.dawn.service.StampService;
import com.dawn.service.dto.CreateStampRequest;
import com.dawn.service.dto.StampResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stamp")
@RequiredArgsConstructor
@Tag(name = "Stamp", description = "스탬프 관련 API")
public class StampController {

    private final StampService stampService;

    @PostMapping("/createStamp")
    @Operation(summary = "스탬프 등록", description = "사용자가 특정 장소에 방문하여 스탬프를 생성합니다.")
    public ResponseEntity<StampResponse> createStamp(@RequestBody CreateStampRequest request) {
        Stamp stamp = stampService.create(request);
        return ResponseEntity.ok(StampResponse.from(stamp));
    }

    @GetMapping("/viewStampListByUser")
    @Operation(summary = "사용자 스탬프 목록 조회", description = "특정 사용자가 수집한 스탬프 목록을 조회합니다.")
    public ResponseEntity<List<StampResponse>> getStampsByUser(@RequestParam Long userSeq) {
        List<StampResponse> responses = stampService.getStampsByUser(userSeq).stream()
                .map(StampResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }
}
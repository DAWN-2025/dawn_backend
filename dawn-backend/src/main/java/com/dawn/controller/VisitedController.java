package com.dawn.controller;

import com.dawn.domain.Visited;
import com.dawn.service.VisitedService;
import com.dawn.service.dto.CreateVisitedRequest;
import com.dawn.service.dto.VisitedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visited")
@RequiredArgsConstructor
@Tag(name = "Visited", description = "방문 기록 및 방명록 API")
public class VisitedController {

    private final VisitedService visitedService;

    @PostMapping("/create")
    @Operation(summary ="방문자 기록, 방명록 생성" , description = "방문자를 기록하고 방명록을 생성한다.")
    public ResponseEntity<VisitedResponse> create(@RequestBody CreateVisitedRequest request) {
        Visited visited = visitedService.create(request);
        return ResponseEntity.ok(VisitedResponse.from(visited));
    }

    @GetMapping("/byLocation")
    @Operation(summary = "장소 기준 방문자 리스트", description = "특정 장소에 방문한 방문자 리스트를 반환한다.")
    public ResponseEntity<List<VisitedResponse>> byLocation(@RequestParam Long locationSeq) {
        List<VisitedResponse> result = visitedService.getByLocation(locationSeq).stream()
                .map(VisitedResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/byUser")
    @Operation(summary = "사용자의 방문 기록을 조회한다", description = "유저별 방문 기록을 조회한다.")
    public ResponseEntity<List<VisitedResponse>> byUser(@RequestParam Long userSeq) {
        List<VisitedResponse> result = visitedService.getByUser(userSeq).stream()
                .map(VisitedResponse::from)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/check")
    @Operation(summary = "방문 여부 확인", description = "유저가 특정 장소를 방문했는지 확인한다.")
    public ResponseEntity<Boolean> checkVisited(@RequestParam Long userSeq, @RequestParam Long locationSeq) {
        return ResponseEntity.ok(visitedService.hasVisited(userSeq, locationSeq));
    }

    @PostMapping("/like")
    @Operation(summary = "좋아요 수를 늘린다", description = "방명록에 작성된 글의 좋아요 수를 늘린다.")
    public ResponseEntity<VisitedResponse> like(@RequestParam Long visitedSeq) {
        Visited liked = visitedService.like(visitedSeq);
        return ResponseEntity.ok(VisitedResponse.from(liked));
    }
}
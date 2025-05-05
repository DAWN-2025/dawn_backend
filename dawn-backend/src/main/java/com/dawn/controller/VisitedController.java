package com.dawn.controller;

import com.dawn.service.VisitedService;
import com.dawn.service.dto.CreateVisitedRequest;
import com.dawn.service.dto.VisitedResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visited")
public class VisitedController {

    private final VisitedService visitedService;

    @PostMapping
    @Operation(summary = "방문 댓글 작성")
    public void writeComment(
            @RequestParam Long locationId,
            @RequestBody CreateVisitedRequest request,
//            @RequestAttribute String uid // 인증 필터 구현후
            @RequestParam String uid // 임시 테스트

    ) {
        visitedService.writeComment(locationId, uid, request);
    }

    @GetMapping
    @Operation(summary = "방명록 댓글 목록 조회")
    public List<VisitedResponse> getComments(
            @RequestParam Long locationId,
//            @RequestAttribute String uid,
            @RequestParam String uid

    ) {
        return visitedService.getComments(locationId, uid);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "댓글 수정")
    public void editComment(
            @PathVariable Long id,
            @RequestBody CreateVisitedRequest request
    ) {
        visitedService.editComment(id, request.getComment());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "댓글 삭제 (소프트 삭제)")
    public void deleteComment(@PathVariable Long id) {
        visitedService.deleteComment(id);
    }

    @PostMapping("/{id}/like")
    @Operation(summary = "댓글 좋아요")
    public void likeComment(@PathVariable Long id) {
        visitedService.likeComment(id);
    }
}
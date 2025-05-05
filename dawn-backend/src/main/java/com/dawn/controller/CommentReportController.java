package com.dawn.controller;

import com.dawn.service.CommentReportService;
import com.dawn.service.dto.CommentReportRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class CommentReportController {

    private final CommentReportService reportService;

    @PostMapping("/{commentId}")
    @Operation(summary = "댓글 신고")
    public void reportComment(
            @PathVariable Long commentId,
//            @RequestAttribute String uid,
            @RequestParam String uid, //인증 필터 전 테스트용
            @Valid @RequestBody CommentReportRequest request
    ) {
        reportService.report(commentId, uid, request);
    }
}
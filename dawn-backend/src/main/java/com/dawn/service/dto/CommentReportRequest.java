package com.dawn.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentReportRequest {

    @NotBlank(message = "신고 내용을 입력해주세요.")
    private String reason; // 선택 입력
}
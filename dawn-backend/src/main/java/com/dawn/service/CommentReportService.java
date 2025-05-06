package com.dawn.service;

import com.dawn.domain.*;
import com.dawn.repository.*;
import com.dawn.service.dto.CommentReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentReportService {

    private final VisitedRepository visitedRepository;
    private final UserRepository userRepository;
    private final CommentReportRepository commentReportRepository;

    @Transactional
    public void report(Long commentId, String userUid, CommentReportRequest request) {
        Visited comment = visitedRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 없음"));
        User reporter = userRepository.findByUid(userUid)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        if (commentReportRepository.existsByCommentAndReporter(comment, reporter)) {
            throw new IllegalStateException("이미 신고한 댓글입니다.");
        }

        if (comment.getUser().getUid().equals(reporter.getUid())) {
            throw new IllegalArgumentException("자신의 댓글은 신고할 수 없습니다.");
        }

        CommentReport report = CommentReport.builder()
                .comment(comment)
                .reporter(reporter)
                .reason(request.getReason())
                .reportedAt(LocalDateTime.now())
                .build();

        commentReportRepository.save(report);

        long reportCount = commentReportRepository.countByComment(comment);
        if (reportCount >= 5) { // 예: 5회 이상이면 자동 숨김
            comment.delete(); // soft delete
        }
    }
}
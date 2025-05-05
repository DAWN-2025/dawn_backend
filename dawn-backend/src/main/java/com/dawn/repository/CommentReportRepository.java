package com.dawn.repository;

import com.dawn.domain.CommentReport;
import com.dawn.domain.User;
import com.dawn.domain.Visited;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentReportRepository extends JpaRepository<CommentReport, Long> {
    boolean existsByCommentAndReporter(Visited comment, User reporter);
    long countByComment(Visited comment);
}
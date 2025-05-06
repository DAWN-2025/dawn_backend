package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT_REPORT_TBL", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"comment_id", "reporter_id"})
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CommentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_SEQ")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID", nullable = false)
    private Visited comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPORTER_ID", nullable = false)
    private User reporter;

    @Column(length = 500)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime reportedAt;
}
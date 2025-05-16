package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LETTER_TBL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LETTER_SEQ")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LETTER_LOCATION", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LETTER_USER", nullable = false)
    private User user;

    @Column(name = "LETTER_STAMP_IMG", length = 45)
    private String stampImg;

    @Column(name = "LETTER_MARK_IMG", length = 45)
    private String markImg;

    @Column(name = "LETTER_CONTENT", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "LETTER_TIME", nullable = false)
    private LocalDateTime letterTime;
}
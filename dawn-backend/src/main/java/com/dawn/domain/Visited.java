package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "VISITED_TBL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Visited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VISITED_SEQ")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VISITED_USER", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VISITED_LOCATION", nullable = false)
    private Location location;

    @Column(name = "VISITED_DATE", nullable = false)
    private LocalDateTime visitedDate;

    @Column(name = "VISITED_COMMENT", length = 1000)
    private String comment;

    @Column(name = "VISITED_LIKES", nullable = false)
    private int likes;

    public void increaseLikes() {
        this.likes += 1;
    }
}
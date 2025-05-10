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

    @Column(name = "VISITED_COMMENT", length = 1000, nullable = false)
    private String comment;

    @Column(name = "VISITED_LIKES", nullable = false)
    private int likes;

    @Column(name = "VISITED_CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "VISITED_UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "VISITED_IS_EDITED", nullable = false)
    private boolean edited;

    @Column(name = "VISITED_IS_DELETED", nullable = false)
    private boolean deleted;

    @Column(name = "VISITED_IMAGE")
    private String imageUrl;

    public void increaseLikes() {
        this.likes++;
    }

    public void editComment(String newComment) {
        this.comment = newComment;
        this.edited = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.deleted = true;
    }
}
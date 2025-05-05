package com.dawn.service.dto;

import com.dawn.domain.Visited;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class VisitedResponse {
    private Long id;
    private String userEmail;
    private String comment;
    private LocalDateTime createdAt;
    private boolean edited;
    private int likes;
    private boolean myComment;
    private boolean visited;

    public static VisitedResponse from(Visited visited, String currentUserEmail, boolean visitedCertified) {
        return VisitedResponse.builder()
                .id(visited.getSeq())
                .userEmail(visited.getUser().getEmail())
                .comment(visited.getComment())
                .createdAt(visited.getCreatedAt())
                .edited(visited.isEdited())
                .likes(visited.getLikes())
                .myComment(visited.getUser().getEmail().equals(currentUserEmail))
                .visited(visitedCertified)
                .build();
    }
}
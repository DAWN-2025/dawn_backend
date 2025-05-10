package com.dawn.service.dto;

import com.dawn.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String uid;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getSeq())
                .email(user.getEmail())
                .uid(user.getUid())
                .build();
    }
}

package com.dawn.controller;

import com.dawn.domain.User;
import com.dawn.service.UserService;
import com.dawn.service.dto.CreateUserRequest;
import com.dawn.service.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 관련 API")
public class UserController {

    private final UserService userService;

    @PostMapping("/createUser")
    @Operation(summary = "유저 생성", description = "Firebase UID 기반 유저 등록")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);
        return ResponseEntity.ok(UserResponse.from(user));
    }
}

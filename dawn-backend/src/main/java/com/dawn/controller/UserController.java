package com.dawn.controller;

import com.dawn.domain.User;
import com.dawn.service.UserService;
import com.dawn.service.dto.CreateUserRequest;
import com.dawn.service.dto.UserResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
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
    @Operation(summary = "유저 생성", description = "Firebase ID 토큰 기반 유저 등록")
    public ResponseEntity<UserResponse> createUser(HttpServletRequest request) throws Exception {
        String idToken = extractTokenFromHeader(request);
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);

        String uid = decodedToken.getUid();
        String email = decodedToken.getEmail();
        // String name = decodedToken.getName();

        User user = userService.createUser(uid, email); // 서비스에서 uid, email로 유저 생성 또는 중복확인
        return ResponseEntity.ok(UserResponse.from(user));
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("Missing or invalid Authorization header.");
        }
        return header.substring(7);
    }
}

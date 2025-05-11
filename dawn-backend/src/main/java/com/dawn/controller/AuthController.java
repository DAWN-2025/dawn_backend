package com.dawn.controller;

import com.dawn.config.JwtUtil;
import com.dawn.service.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("Authorization") String authHeader) {
        String firebaseToken = authHeader.replace("Bearer ", "");

        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(firebaseToken);

            String uid = decodedToken.getUid();
            String email = decodedToken.getEmail();

            // 인증 후 유저 자동 생성
            userService.createUser(uid, email);

            String jwt = jwtUtil.generateToken(uid, email);
            return ResponseEntity.ok(Map.of("token", jwt));
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(401).body("Invalid Firebase ID token");
        }
    }
}
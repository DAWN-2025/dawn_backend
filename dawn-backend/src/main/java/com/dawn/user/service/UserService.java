package com.dawn.user.service;

import com.dawn.user.domain.User;
import com.dawn.user.repository.UserRepository;
import com.dawn.user.service.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest request) {

        Optional<User> existingUser = userRepository.findByUid(request.getUid());

        if (existingUser.isPresent()) {
            return existingUser.get();
        }

        User user = User.builder()
                .email(request.getEmail())
                .uid(request.getUid())
                .build();

        return userRepository.save(user);
    }

    public Optional<User> getUserByUid(String uid) {
        return userRepository.findByUid(uid);
    }


}

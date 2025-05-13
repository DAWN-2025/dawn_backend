package com.dawn.service;

import com.dawn.domain.User;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

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

    //Uid로 유저를 찾는 로직이 있어야할지 모르겠음, 없어도 될 것 같음
    public Optional<User> getUserByUid(String uid) {
        return userRepository.findByUid(uid);
    }

    public User getUserBySeq(Long seq) {
        return userRepository.findById(seq)
                .orElseThrow(() -> new IllegalArgumentException("해당 seq의 사용자가 없습니다."));
    }


    public User createUser(String uid, String email) {
        if (userRepository.findByUid(uid).isPresent()) {
            throw new IllegalStateException("이미 등록된 사용자입니다: uid = " + uid);
        }
        return userRepository.save(new User(uid, email));
    }}

package com.dawn.service;

import com.dawn.domain.Letter;
import com.dawn.domain.Location;
import com.dawn.domain.User;
import com.dawn.repository.LetterRepository;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.CreateLetterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LetterService {

    private final LetterRepository letterRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public Letter create(CreateLetterRequest request) {
        User user = userRepository.findById(request.getUserSeq())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        Location location = locationRepository.findById(request.getLocationSeq())
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));

        Letter letter = Letter.builder()
                .user(user)
                .location(location)
                .content(request.getContent())
                .stampImg(request.getStampImg())
                .markImg(request.getMarkImg())
                .letterTime(LocalDateTime.now())
                .build();

        return letterRepository.save(letter);
    }

    public List<Letter> getByLocation(Long locationSeq, Long userSeq) {
        Location location = locationRepository.findById(locationSeq)
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));
        return letterRepository.findByLocationAndUser(locationSeq, userSeq);
    }

    public List<Letter> getByUser(Long userSeq) {
        User user = userRepository.findById(userSeq)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        return letterRepository.findByUser(user);
    }
}
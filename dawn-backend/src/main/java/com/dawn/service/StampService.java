package com.dawn.service;

import com.dawn.domain.Location;
import com.dawn.domain.Stamp;
import com.dawn.domain.User;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.StampRepository;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.CreateStampRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StampService {
    private final UserService userService;
    private final StampRepository stampRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;


    public Stamp create(CreateStampRequest request) {
        Location location = locationRepository.findById(request.getLocationSeq())
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));
        User user = userService.getUserBySeq(request.getUserSeq());

        Stamp stamp = Stamp.builder()
                .location(location)
                .owner(user)
                .statusTime(LocalDateTime.now())
                .build();

        return stampRepository.save(stamp);
    }

    public List<Stamp> getStampsByUser(Long userSeq) {
        User user = userService.getUserBySeq(userSeq);

        return stampRepository.findByOwner(user);
    }
}
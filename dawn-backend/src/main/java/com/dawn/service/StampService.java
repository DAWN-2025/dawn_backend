package com.dawn.service;

import com.dawn.domain.Event;
import com.dawn.domain.Location;
import com.dawn.domain.Stamp;
import com.dawn.domain.User;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.StampRepository;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.CreateStampRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StampService {
    private final UserService userService;
    private final EventService eventService;
    private final StampRepository stampRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;


    public Stamp create(CreateStampRequest request) {
        Location location = locationRepository.findById(request.getLocationSeq())
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));
        User user = userService.getUserByUid(request.getUserUid())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        Event event = eventService.getById(location.getEvent().getSeq());

        Stamp stamp = Stamp.builder()
                .location(location)
                .owner(user)
                .event(event)
                .statusTime(LocalDateTime.now())
                .stampImage("image.png")
                .build();

        return stampRepository.save(stamp);
    }

    public Map<Event, List<Stamp>> getStampsByUser(String userUid) {
        User user = userService.getUserByUid(userUid)
                .orElseThrow(() -> new IllegalArgumentException("해당 UID의 사용자가 존재하지 않습니다."));

        List<Stamp> stampList = stampRepository.findByOwner(user);

        return stampList.stream()
                .collect(Collectors.groupingBy(Stamp::getEvent));
    }
}
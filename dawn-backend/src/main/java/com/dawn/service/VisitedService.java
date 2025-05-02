package com.dawn.service;

import com.dawn.domain.Location;
import com.dawn.domain.User;
import com.dawn.domain.Visited;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.UserRepository;
import com.dawn.repository.VisitedRepository;
import com.dawn.service.dto.CreateVisitedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitedService {

    private final VisitedRepository visitedRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public Visited create(CreateVisitedRequest request) {
        User user = userRepository.findById(request.getUserSeq())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        Location location = locationRepository.findById(request.getLocationSeq())
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));

        Visited visited = Visited.builder()
                .user(user)
                .location(location)
                .comment(request.getComment())
                .visitedDate(LocalDateTime.now())
                .likes(0)
                .build();

        return visitedRepository.save(visited);
    }

    public List<Visited> getByLocation(Long locationSeq) {
        Location location = locationRepository.findById(locationSeq)
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));
        return visitedRepository.findByLocation(location);
    }

    public List<Visited> getByUser(Long userSeq) {
        User user = userRepository.findById(userSeq)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        return visitedRepository.findByUser(user);
    }

    public boolean hasVisited(Long userSeq, Long locationSeq) {
        User user = userRepository.findById(userSeq)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        Location location = locationRepository.findById(locationSeq)
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));
        return visitedRepository.existsByUserAndLocation(user, location);
    }

    public Visited like(Long visitedSeq) {
        Visited visited = visitedRepository.findById(visitedSeq)
                .orElseThrow(() -> new IllegalArgumentException("방문 기록이 존재하지 않습니다."));
        visited.increaseLikes();
        return visitedRepository.save(visited);
    }
}
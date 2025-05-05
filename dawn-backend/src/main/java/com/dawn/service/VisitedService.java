package com.dawn.service;

import com.dawn.domain.Location;
import com.dawn.domain.User;
import com.dawn.domain.Visited;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.UserRepository;
import com.dawn.repository.VisitedRepository;
import com.dawn.service.dto.CreateVisitedRequest;
import com.dawn.service.dto.VisitedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitedService {

    private final VisitedRepository visitedRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Transactional
    public void writeComment(Long locationId, String userUid, CreateVisitedRequest request) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장소입니다."));
        User user = userRepository.findByUid(userUid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Visited visited = Visited.builder()
                .location(location)
                .user(user)
                .comment(request.getComment())
                .imageUrl(request.getImageUrl())
                .likes(0)
                .createdAt(LocalDateTime.now())
                .edited(false)
                .deleted(false)
                .build();

        visitedRepository.save(visited);
    }

    @Transactional(readOnly = true)
    public List<VisitedResponse> getComments(Long locationId, String currentUserUid) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장소입니다."));

        return visitedRepository.findByLocationAndDeletedFalseOrderByCreatedAtDesc(location)
                .stream()
                .map(v -> VisitedResponse.from(v, currentUserUid))
                .toList();
    }

    @Transactional
    public void editComment(Long id, String newComment) {
        Visited visited = visitedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        visited.editComment(newComment);
    }

    @Transactional
    public void deleteComment(Long id) {
        Visited visited = visitedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        visited.delete();
    }

    @Transactional
    public void likeComment(Long id) {
        Visited visited = visitedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        visited.increaseLikes();
    }
}
package com.dawn.service;

import com.dawn.domain.Letter;
import com.dawn.domain.Location;
import com.dawn.domain.User;
import com.dawn.repository.LetterRepository;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.CreateLetterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LetterService {

    private final LetterRepository letterRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;


    @Value("${letter.api.url}")
    private String FAST_API_URL;


    public Letter create(CreateLetterRequest request) {
        String userUid = request.getUserUid();
        Long locationSeq = request.getLocationSeq();

        String today = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        String sessionId = "user-" + userUid + "-" + today;

        // 1. FastAPI에 session_id 전송
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = Map.of("session_id", sessionId);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                FAST_API_URL, entity, Map.class
        );

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("FastAPI 편지 생성 실패");
        }

        String content = (String) response.getBody().get("letter");

        // 2. 사용자, 장소 조회
        User user = userRepository.findByUid(userUid).orElseThrow();
        Location location = locationRepository.findById(locationSeq).orElseThrow();

        // 3. 편지 생성
        Letter letter = Letter.builder()
                .user(user)
                .location(location)
                .content(content)
                .letterTime(LocalDateTime.now())  // ✅ 직접 넣음
                .build();

        return letterRepository.save(letter);
    }

    public List<Letter> getByLocation(Long locationSeq, String userUid) {
        User user = userRepository.findByUid(userUid)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        Location location = locationRepository.findById(locationSeq)
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));
        return letterRepository.findByLocationAndUser(location, user);
    }
    public List<Letter> getByUser(String userUid) {
        User user = userRepository.findByUid(userUid)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        return letterRepository.findByUser(user);
    }
}
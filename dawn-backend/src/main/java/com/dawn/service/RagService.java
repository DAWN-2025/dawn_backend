package com.dawn.service;

import com.dawn.domain.Chat;
import com.dawn.domain.Location;
import com.dawn.domain.User;
import com.dawn.repository.ChatRepository;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.ChatResponse;
import com.dawn.service.dto.RagRequest;
import com.dawn.service.dto.RagResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RagService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    private static final String FAST_API_URL = "FAST_API_URL";

    public RagService(ChatRepository chatRepository, UserRepository userRepository, LocationRepository locationRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    public ChatResponse queryToRag(Long userSeq, Long locationSeq, String chatTarget, String chatQuestion) {
        RagRequest request = new RagRequest(chatQuestion);

        // HTTP 엔티티 생성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RagRequest> entity = new HttpEntity<>(request, headers);

        // 요청 보내고 응답 받기
        ResponseEntity<RagResponse> response = restTemplate.postForEntity(
                FAST_API_URL, entity, RagResponse.class);

        String answer = response.getBody().getAnswer();

        // DB에 저장
        User user = userRepository.findById(userSeq).orElseThrow();
        Location location = locationRepository.findById(locationSeq).orElseThrow();

        Chat chat = Chat.builder()
                .user(user)
                .location(location)
                .chatTarget(chatTarget)
                .chatQuestion(chatQuestion)
                .chatAnswer(answer)
                .build();

        chatRepository.save(chat);

        return ChatResponse.from(chat);
    }
}

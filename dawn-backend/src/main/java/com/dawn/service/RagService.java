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
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class RagService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

//    @Value("${rag.api.url}")
    private final String FAST_API_URL = "http://rag-api:8000/chat";


    public RagService(ChatRepository chatRepository, UserRepository userRepository, LocationRepository locationRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }
    // chatTarget 잠시 제거
    public ChatResponse queryToRag(String userUid, Long locationSeq, String chatQuestion) {
        String today = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);

        String sessionId = "user-" + userUid + "-" + today;
        RagRequest request = new RagRequest(sessionId, chatQuestion);

        // HTTP 엔티티 생성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RagRequest> entity = new HttpEntity<>(request, headers);

        // 요청 보내고 응답 받기
        ResponseEntity<RagResponse> response = restTemplate.postForEntity(
                FAST_API_URL, entity, RagResponse.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("FastAPI 응답 실패");
        }

        String answer = response.getBody().getAnswer();

        // DB에 저장
        User user = userRepository.findByUid(userUid).orElseThrow();
        Location location = locationRepository.findById(locationSeq).orElseThrow();

        Chat chat = Chat.builder()
                .user(user)
                .location(location)
                .chatQuestion(chatQuestion)
                .chatAnswer(answer)
                .build();

        chatRepository.save(chat);

        return ChatResponse.from(chat);
    }
}

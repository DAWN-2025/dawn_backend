package com.dawn.service;

import com.dawn.domain.Chat;
import com.dawn.domain.Location;
import com.dawn.domain.User;
import com.dawn.repository.ChatRepository;
import com.dawn.repository.LocationRepository;
import com.dawn.repository.UserRepository;
import com.dawn.service.dto.SaveChatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public Chat saveChat(SaveChatRequest request) {
        User user = userRepository.findById(request.getUserSeq())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        Location location = locationRepository.findById(request.getLocSeq())
                .orElseThrow(() -> new IllegalArgumentException("장소가 존재하지 않습니다."));

        Chat chat = Chat.builder()
                .user(user)
                .location(location)
                .chatTarget(request.getChatTarget())
                .chatQuestion(request.getChatQuestion())
                .chatAnswer(request.getChatAnswer())
                .build();

        return chatRepository.save(chat);
    }
}

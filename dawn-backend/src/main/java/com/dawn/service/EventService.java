package com.dawn.service;

import com.dawn.domain.Event;
import com.dawn.repository.EventRepository;
import com.dawn.service.dto.CreateEventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getUpcomingEvents() {
        LocalDate today = LocalDate.now();
        return eventRepository.recommendEventByDate(today);
    }

    public List<Event> getAllByDateDesc() {
        return eventRepository.findAllByOrderByDateDesc();
    }

    public List<Event> search(String keyword) {
        return eventRepository.searchEventByKeyword(keyword);
    }

    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사건이 존재하지 않습니다. id=" + id));
    }

    //이건 필요 없을 듯
    public Event create(CreateEventRequest request) {
        Event event = Event.builder()
                .name(request.getName())
                .date(request.getOccurDate())
                .nation(request.getNation())
                .category(request.getCategory())
                .nameEng(request.getNameEng())
                .nationEng(request.getNationEng())
                .categoryEng(request.getCategoryEng())
                .info(request.getInfo())
                .build();

        return eventRepository.save(event);
    }

}

package com.dawn.service;

import com.dawn.domain.Event;
import com.dawn.repository.EventRepository;
import com.dawn.service.dto.EventStampResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
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

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


}

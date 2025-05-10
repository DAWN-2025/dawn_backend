package com.dawn.service;

import com.dawn.domain.Event;
import com.dawn.domain.Keyword;
import com.dawn.domain.Location;
import com.dawn.repository.EventRepository;
import com.dawn.repository.KeywordRepository;
import com.dawn.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;
    private final LocationService locationService;


    public List<Keyword> getByLocation(Long locationSeq) {
        Location location = locationService.getById(locationSeq);
        return keywordRepository.findByLocation(location);
    }
}
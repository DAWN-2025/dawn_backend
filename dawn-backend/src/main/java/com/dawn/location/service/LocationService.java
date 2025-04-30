package com.dawn.location.service;

import com.dawn.location.domain.Location;
import com.dawn.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
//    private final EventRepository eventRepository;

    public List<Location> getLocationsByEvent(Long eventId) {
        return locationRepository.findByEventId(eventId);
    }

    public List<Location> searchLocations(String keyword) {
        return locationRepository.searchByKeyword(keyword);
    }

    public Location getById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 존재하지 않습니다. id=" + id));
    }
}

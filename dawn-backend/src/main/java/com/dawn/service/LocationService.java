package com.dawn.service;

import com.dawn.domain.Location;
import com.dawn.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> getLocationsByEvent(Long eventId) {
        return locationRepository.findByEventSeq(eventId);
    }

    public List<Location> searchLocations(String keyword) {
        return locationRepository.searchByKeyword(keyword);
    }

    public Location getById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 장소가 존재하지 않습니다. id=" + id));
    }
}

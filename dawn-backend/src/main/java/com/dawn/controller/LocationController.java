package com.dawn.controller;

import com.dawn.domain.Location;
import com.dawn.service.LocationService;
import com.dawn.service.dto.LocationResponse;
import com.dawn.service.dto.LocationSummaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Tag(name = "Location", description = "장소 관련 API")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/viewLocationByEvent")
    @Operation(summary = "사건 기준으로 장소 조회")
    public ResponseEntity<List<LocationSummaryResponse>> byEvent(@RequestParam Long eventId) {
        List<LocationSummaryResponse> responses = locationService.getLocationsByEvent(eventId)
                .stream().map(LocationSummaryResponse::from).toList();

        return ResponseEntity.ok(responses);
    }


    // 이름, 주소 기준 검색
    @GetMapping("/viewLocationBySearch")
    @Operation(summary = "장소 검색")
    public ResponseEntity<List<LocationSummaryResponse>> bySearch(@RequestParam String keyword) {
        List<LocationSummaryResponse> responses = locationService.searchLocations(keyword)
                .stream().map(LocationSummaryResponse::from).toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/viewLocationByInfo")
    @Operation(summary = "장소 상세 조회")
    public ResponseEntity<LocationResponse> byInfo(@RequestParam Long id) {
        Location loc = locationService.getById(id);
        return ResponseEntity.ok(LocationResponse.from(loc));
    }

    @GetMapping("/list")
    @Operation(summary = "등록된 장소 리스트 조회")
    public ResponseEntity<List<LocationSummaryResponse>> viewList() {
        List<LocationSummaryResponse> responses = locationService.getAllLocations()
                .stream()
                .map(LocationSummaryResponse::from)
                .toList();
        return ResponseEntity.ok(responses);

    }



}

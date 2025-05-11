package com.dawn.controller;

import com.dawn.domain.Event;
import com.dawn.domain.Stamp;
import com.dawn.repository.EventRepository;
import com.dawn.service.EventService;
import com.dawn.service.StampService;
import com.dawn.service.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stamp")
@RequiredArgsConstructor
@Tag(name = "Stamp", description = "스탬프 관련 API")
public class StampController {

    private final StampService stampService;
    private final EventService eventService;
    private final EventRepository eventRepository;

    @PostMapping("/createStamp")
    @Operation(summary = "스탬프 등록", description = "사용자가 특정 장소에 방문하여 스탬프(기록)를 생성합니다.")
    public ResponseEntity<StampResponse> createStamp(@RequestBody CreateStampRequest request) {
        Stamp stamp = stampService.create(request);
        return ResponseEntity.ok(StampResponse.from(stamp));
    }

    @GetMapping("/viewStampListByUser")
    @Operation(summary = "사용자 스탬프 목록 조회", description = "특정 사용자가 수집한 스탬프 목록을 이벤트별로 조회합니다.")
    public ResponseEntity<List<EventStampGroupResponse>> getStampsByUser(@RequestParam String userUid) {
        Map<Event, List<Stamp>> grouped = stampService.getStampsByUser(userUid);

        List<EventStampGroupResponse> responses = grouped.entrySet().stream()
                .map(entry -> EventStampGroupResponse.from(entry.getKey(), entry.getValue()))
                .toList();

        return ResponseEntity.ok(responses);
    }

//    @GetMapping("/viewStampListByUser")
//    @Operation(summary = "사용자 스탬프 목록 조회", description = "특정 사용자가 수집한 스탬프 목록을 이벤트별로 조회합니다.")
//    public ResponseEntity<List<EventStampResponse>> getStampsByUser(@RequestParam Long userSeq) {
//        List<EventStampResponse> eventStampList = eventRepository.getStampListByUser(userSeq);
//
//        return ResponseEntity.ok(eventStampList);
//    }

    @GetMapping("/getStampImage")
    @Operation(summary = "모든 스탬프의 이미지 불러오기", description = "이벤트 마다 갖는 스탬프의 이미지를 조회합니다.")
    public ResponseEntity<List<EventStampResponse>> getStampImage() {
        List<EventStampResponse> eventStampList = eventRepository.getAllEventStampImg();

        return ResponseEntity.ok(eventStampList);
    }
}
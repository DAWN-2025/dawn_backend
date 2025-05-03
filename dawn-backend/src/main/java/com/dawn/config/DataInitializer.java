//package com.dawn.config;
//
//import com.dawn.domain.Event;
//import com.dawn.domain.Location;
//import com.dawn.repository.EventRepository;
//import com.dawn.repository.LocationRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//
//    private final EventRepository eventRepository;
//    private final LocationRepository locationRepository;
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//
//
//        System.out.println("🔥 DataInitializer 실행됨");
//
//        if (eventRepository.count() == 0) {
//
//            Event event = eventRepository.save(Event.builder()
//                    .name("5.18 광주민주화운동")
//                    .info("1980년 5월 18일부터 27일까지 광주에서 벌어진 민주화 운동")
//                    .date(LocalDateTime.of(1980, 5, 18, 0, 0))
//                    .nation("대한민국")
//                    .category("민주화운동")
//                    .nameEng("Gwangju Uprising")
//                    .nationEng("Republic of Korea")
//                    .categoryEng("Democratization Movement")
//                    .build());
//
//            Location location = Location.builder()
//                    .name("금남로")
//                    .event(event)
//                    .address("광주광역시 동구 금남로")
//                    .image("https://example.com/images/geumnamro.jpg")
//                    .info("5.18 민주화운동 당시 주요 시위가 일어났던 장소")
//                    .nameEng("Geumnam-ro")
//                    .infoEng("Main protest site during the May 18 Gwangju Uprising")
//                    .addressEng("Geumnam-ro, Dong-gu, Gwangju, South Korea")
//                    .build();
//
//            locationRepository.save(location);
//        }
//    }
//}
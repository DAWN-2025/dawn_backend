package com.dawn.repository;

import com.dawn.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    //쿼리 다시 짜야함
    List<Event> findByDateAfterOrderByDateAsc(LocalDateTime today);

    List<Event> findAllByOrderByDateDesc();


    // 작동되는지 확인
    List<Event> findByNameContainingIgnoreCaseOrNationContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String name, String nation, String category
    );


}

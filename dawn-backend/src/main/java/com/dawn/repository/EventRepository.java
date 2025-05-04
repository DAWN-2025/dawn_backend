package com.dawn.repository;

import com.dawn.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query (value = "SELECT * FROM EVENT_TBL ORDER BY ABS(DAY_OF_YEAR(EVENT_DATE) - DAY_OF_YEAR(PARSEDATETIME(:today, 'yyyy-MM-dd'))) LIMIT 1",
        nativeQuery = true) // 가장 최근에 있었던 사건 하나 추천 해주는 쿼리
    List<Event> recommendEventByDate(LocalDate today);

    List<Event> findAllByOrderByDateDesc();

    @Query (value = "SELECT * FROM EVENT_TBL et " +
            "WHERE et.EVENT_SEQ IN (" +
            "  SELECT KEYWORD_EVENT FROM KEYWORD_TBL kt WHERE kt.KEYWORD LIKE CONCAT('%', :keyword, '%')" +
            ")", nativeQuery = true) // 키워드로 이벤트명 검색
    List<Event> searchEventByKeyword(String keyword);

}

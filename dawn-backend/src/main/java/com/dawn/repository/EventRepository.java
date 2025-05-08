package com.dawn.repository;

import com.dawn.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query (value = "SELECT * FROM EVENT_TBL ORDER BY ABS(DAY_OF_YEAR(EVENT_DATE) - DAY_OF_YEAR(PARSEDATETIME(:today, 'yyyy-MM-dd'))) LIMIT 1",
        nativeQuery = true) // 가장 최근에 있었던 사건 하나 추천 해주는 쿼리
    List<Event> recommendEventByDate(LocalDate today);


    List<Event> findAllByOrderByDateDesc();

    @Query("""
    SELECT DISTINCT e
    FROM Event e
    LEFT JOIN e.keywords k
    WHERE (:keyword IS NOT NULL AND :keyword <> '')
      AND (
        LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(e.nameEng) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(k.keyword) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(k.keywordEng) LIKE LOWER(CONCAT('%', :keyword, '%'))
      )
""")
    List<Event> searchEventByKeyword(@Param("keyword") String keyword);
}

package com.dawn.repository;

import com.dawn.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByEventSeq(Long eventId);


    @Query("""
    SELECT DISTINCT l
    FROM Location l
    LEFT JOIN l.keywords k
    WHERE (:keyword IS NOT NULL AND :keyword <> '')
      AND(
        LOWER(k.keyword) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(k.keywordEng) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(l.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(l.nameEng) LIKE LOWER(CONCAT('%', :keyword, '%'))

      )
    """)
    List<Location> searchByKeyword(@Param("keyword") String keyword);
}

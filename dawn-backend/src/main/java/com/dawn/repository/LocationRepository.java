package com.dawn.repository;

import com.dawn.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByEventSeq(Long eventId);


    //쿼리문 수정해야할듯
    @Query("""
    SELECT DISTINCT l
    FROM Location l
    JOIN Keyword k ON k.location = l
    WHERE (:keyword IS NOT NULL AND :keyword <> '')
      AND LOWER(k.keyword) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<Location> searchByKeyword(@Param("keyword") String keyword);}

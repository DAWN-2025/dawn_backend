package com.dawn.repository;

import com.dawn.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByEventSeq(Long eventId);


    //쿼리문 수정해야할듯
    @Query("SELECT l FROM Location l WHERE " +
            "LOWER(l.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(l.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")

    List<Location> searchByKeyword(@Param("keyword") String keyword);
}

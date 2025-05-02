package com.dawn.repository;

import com.dawn.domain.Keyword;
import com.dawn.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    List<Keyword> findByLocation(Location location);

}

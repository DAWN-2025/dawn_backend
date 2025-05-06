package com.dawn.repository;

import com.dawn.domain.Location;
import com.dawn.domain.Visited;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitedRepository extends JpaRepository<Visited, Long> {
    List<Visited> findByLocationAndDeletedFalseOrderByCreatedAtDesc(Location location);
}
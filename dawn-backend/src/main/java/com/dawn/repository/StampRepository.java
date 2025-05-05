package com.dawn.repository;

import com.dawn.domain.Location;
import com.dawn.domain.Stamp;
import com.dawn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StampRepository extends JpaRepository<Stamp, Long> {
    List<Stamp> findByOwner(User user);

    boolean existsByOwnerAndLocation(User owner, Location location);
}
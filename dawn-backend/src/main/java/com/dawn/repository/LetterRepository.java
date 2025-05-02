package com.dawn.repository;

import com.dawn.domain.Letter;
import com.dawn.domain.Location;
import com.dawn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByLocation(Location location);
    List<Letter> findByUser(User user);

}

package com.dawn.repository;

import com.dawn.domain.Letter;
import com.dawn.domain.Location;
import com.dawn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByLocation(Location location);

    @Query(value = "SELECT * FROM LETTER_TBL WHERE LETTER_USER = :userSeq AND LETTER_LOCATION = :locationSeq",
        nativeQuery = true)
    List<Letter> findByLocationAndUser(Long locationSeq, Long userSeq);

    List<Letter> findByUser(User user);

}

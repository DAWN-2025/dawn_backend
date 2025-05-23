package com.dawn.repository;

import com.dawn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUid(String uid);

    Optional<User> findByEmail(String email);

}

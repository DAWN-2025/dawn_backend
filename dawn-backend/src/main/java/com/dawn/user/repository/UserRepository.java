package com.dawn.user.repository;

import com.dawn.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUid(String uid);

    Optional<User> findByEmail(String email);
}

package com.erapp23.repository;

import com.erapp23.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    // 👇 THIS LINE IS MANDATORY
    User findByUsernameAndPassword(String username, String password);
}

package com.example.JavaPatternsTask14.repositories;

import com.example.JavaPatternsTask14.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<List<User>> getAllBy();

    Optional<Integer> deleteUserById(Long id);
}

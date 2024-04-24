package com.example.JavaPatternsTask14.repositories;

import com.example.JavaPatternsTask14.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhoneRepo extends JpaRepository<Phone, Long> {
    Optional<List<Phone>> getAllBy();
    Optional<List<Phone>> findAllByName(String name);

    Optional<Integer> deleteUserById(Long id);
}

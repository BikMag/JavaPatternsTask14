package com.example.JavaPatternsTask14.repositories;

import com.example.JavaPatternsTask14.models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManufactureRepo extends JpaRepository<Manufacture, Long>{
    Optional<List<Manufacture>> getAllBy();

    Optional<Integer> deleteUserById(Long id);
}

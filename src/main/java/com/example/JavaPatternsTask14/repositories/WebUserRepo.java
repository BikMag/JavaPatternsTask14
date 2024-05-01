package com.example.JavaPatternsTask14.repositories;

import com.example.JavaPatternsTask14.models.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepo extends JpaRepository<WebUser, Long> {
    WebUser getByUsername(String username);
}

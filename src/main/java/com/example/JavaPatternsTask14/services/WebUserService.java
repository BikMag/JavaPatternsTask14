package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.dto.WebUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface WebUserService extends UserDetailsService {
    void saveUser(WebUserDTO user);
}

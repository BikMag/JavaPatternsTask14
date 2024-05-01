package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.models.WebUser;
import com.example.JavaPatternsTask14.repositories.WebUserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class WebUserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final WebUserRepo users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Searching user {}...", username);

        WebUser user = users.getByUsername(username);

        if (user == null) {
            log.info("User {} not found", username);

            throw new UsernameNotFoundException("User not found");
        }

        return new User(user.getUsername(), user.getPassword(), List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        ));
    }

    public void saveUser(WebUser webUser) {
        log.info("Saving user {}...", webUser.getUsername());

        WebUser user = new WebUser();

        user.setUsername(webUser.getUsername());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));

        users.save(user);
    }
}

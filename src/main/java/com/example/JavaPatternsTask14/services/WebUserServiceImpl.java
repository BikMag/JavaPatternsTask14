package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.dto.WebUserDTO;
import com.example.JavaPatternsTask14.models.WebUser;
import com.example.JavaPatternsTask14.repositories.WebUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
public class WebUserServiceImpl implements WebUserService {
    private final PasswordEncoder passwordEncoder;
    private final WebUserRepo users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser user = users.getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(user.getUsername(), user.getPassword(), List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        ));
    }

    @Override
    public void saveUser(WebUserDTO webUserDTO) {
        WebUser user = new WebUser();

        user.setUsername(webUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(webUserDTO.getPassword()));

        users.save(user);
    }
}

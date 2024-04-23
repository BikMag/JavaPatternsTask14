package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.models.User;
import com.example.JavaPatternsTask14.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    @ResponseBody
    public User addUser(
            @RequestBody User user
    ) {
        service.addUser(user);
        return user;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        return "Count: " + service.deleteUserById(id);
    }
}

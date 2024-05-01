package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.dto.WebUserDTO;
import com.example.JavaPatternsTask14.models.WebUser;
import com.example.JavaPatternsTask14.services.WebUserService;
import com.example.JavaPatternsTask14.services.WebUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register")
@RequiredArgsConstructor
@Controller
public class RegistrationController {
    private final WebUserService webUserService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new WebUserDTO("",""));

        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") WebUserDTO userDTO) {
        webUserService.saveUser(userDTO);

        return "redirect:/register?success";
    }
}

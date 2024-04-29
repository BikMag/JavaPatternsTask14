package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService service;

    @GetMapping(value = "/{email}")
    @ResponseBody
    public String sendMessage(@PathVariable("email") String email) {
        service.sendEmail(email, "Welcome","This is test from Java application");
        return "Email was sent";
    }
}

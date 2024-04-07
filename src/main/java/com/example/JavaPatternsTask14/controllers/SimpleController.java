package com.example.JavaPatternsTask14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }
}

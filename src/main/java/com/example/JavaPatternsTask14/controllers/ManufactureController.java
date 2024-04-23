package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.models.User;
import com.example.JavaPatternsTask14.services.ManufactureService;
import com.example.JavaPatternsTask14.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manufactures")
public class ManufactureController {
    private final ManufactureService service;

    @GetMapping
    @ResponseBody
    public List<Manufacture> getUsers() {
        return service.getAllManufactures();
    }

    @PostMapping
    @ResponseBody
    public Manufacture addManufacture(
            @RequestBody Manufacture manufacture
    ) {
        service.addManufacture(manufacture);
        return manufacture;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteManufacture(@PathVariable Long id) {
        return "Count: " + service.deleteManufactureById(id);
    }
}

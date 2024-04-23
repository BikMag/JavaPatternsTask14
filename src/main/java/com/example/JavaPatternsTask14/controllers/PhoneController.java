package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.services.PhoneService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/phones")
public class PhoneController {
    private final PhoneService service;

    @GetMapping
    @ResponseBody
    public List<Phone> getPhones() {
        return service.getAllPhones();
    }

    @PostMapping
    @ResponseBody
    public Phone addPhone(
            @RequestBody Phone phone
    ) {
        service.addPhone(phone);
        return phone;
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deletePhone(@PathVariable Long id) {
        return "Count: " + service.deletePhoneById(id);
    }
}

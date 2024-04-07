package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.models.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/phones")
public class PhoneController {
    private final Phone[] lPhones = {new Phone("Sony", 2020)};
    private final List<Phone> phones = new ArrayList<>(Arrays.asList(lPhones));

    @GetMapping
    @ResponseBody
    public List<Phone> getPhones() {
        System.out.println("GET\n" + phones);
        return phones;
    }
    @PostMapping
    @ResponseBody
    public Phone createPhone(@RequestBody Phone phone) {
        System.out.println("POST\n" + phone);
        phones.add(phone);
        return phone;
    }

    @DeleteMapping("/{index}")
    @ResponseBody
    public boolean deletePhone(@PathVariable int index) {
        System.out.println("DELETE\n" + phones.get(index));
        if (index >= 0 && index < phones.size()) {
            phones.remove(index);
            return true;
        }
        return false;
    }
}

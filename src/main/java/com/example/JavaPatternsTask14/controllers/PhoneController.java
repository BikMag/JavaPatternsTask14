package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.services.PhoneService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @GetMapping(value = "/phone/{phoneId}/manufacture")
    @ResponseBody
    public Manufacture getPhoneManufacture(@PathVariable("phoneId")
                                         Long phoneId){
        return service.getManufactureByPhone(phoneId);
    }

    @GetMapping(value = "/phone/{name}")
    @ResponseBody
    public List<Phone> getAllByName(@PathVariable("name") String name) {
        return service.getPhonesByName(name);
    }

//  Фильтрация (сортировка) данных
    @GetMapping("/sort/{column}")
    @ResponseBody
    public List<Phone> sortPhone(@PathVariable("column") String column) {
        return service.sortPhones(column);
    }
}

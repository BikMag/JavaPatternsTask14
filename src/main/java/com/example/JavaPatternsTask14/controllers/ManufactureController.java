package com.example.JavaPatternsTask14.controllers;

import com.example.JavaPatternsTask14.models.Manufacture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manufactures")
public class ManufactureController {
    private final List<Manufacture> manufactures = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Manufacture> getManufactures() {
        System.out.println("GET\n" + manufactures);
        return manufactures;
    }
    @PostMapping
    @ResponseBody
    public Manufacture createManufacture(@RequestBody Manufacture manufacture) {
        System.out.println("POST\n" + manufacture);
        manufactures.add(manufacture);
        return manufacture;
    }

    @DeleteMapping("/{index}")
    @ResponseBody
    public boolean deleteManufacture(@PathVariable int index) {
        System.out.println("DELETE\n" + index);
        if (index >= 0 && index < manufactures.size()) {
            manufactures.remove(index);
            return true;
        }
        return false;
    }
}

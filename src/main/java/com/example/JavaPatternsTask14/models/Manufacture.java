package com.example.JavaPatternsTask14.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Manufacture {
    private String name;
    private String address;

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

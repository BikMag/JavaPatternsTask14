package com.example.JavaPatternsTask14.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {
    private String name;
    private int creationYear;

    public Phone(String name, int creationYear) {
        this.name = name;
        this.creationYear = creationYear;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", creationYear='" + creationYear + '\'' +
                '}';
    }
}

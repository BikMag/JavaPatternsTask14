package com.example.JavaPatternsTask14.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @SequenceGenerator(name = "phones_seq", sequenceName =
            "phones_sequence", allocationSize = 1)
    @GeneratedValue(generator = "phones_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_year")
    private int creationYear;

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", creationYear='" + creationYear + '\'' +
                '}';
    }
}
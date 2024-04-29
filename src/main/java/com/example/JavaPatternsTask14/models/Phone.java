package com.example.JavaPatternsTask14.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JsonIgnore
    public Manufacture manufacture;

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationYear='" + creationYear + '\'' +
                ", manufactureId='" + manufacture.getId() + '\'' +
                '}';
    }
}

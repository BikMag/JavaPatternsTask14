package com.example.JavaPatternsTask14.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manufactures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manufacture {
    @Id
    @SequenceGenerator(name = "manufactures_seq", sequenceName =
            "manufactures_sequence", allocationSize = 1)
    @GeneratedValue(generator = "manufactures_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "manufacture")
    private List<Phone> phones;

    @Override
    public String toString() {
        return "Manufacture{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

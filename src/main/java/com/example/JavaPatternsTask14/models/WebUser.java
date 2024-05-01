package com.example.JavaPatternsTask14.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "web_users")
@Getter
@Setter
@NoArgsConstructor
public class WebUser {
    @Id
    @SequenceGenerator(name = "web_users_seq", sequenceName =
            "web_users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "web_users_seq", strategy =
            GenerationType.SEQUENCE)
    long id;

    private String username;
    private String password;

    public WebUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.models.User;
import com.example.JavaPatternsTask14.repositories.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepository;
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
//        User user = new User();
//        user.setFirstName("Vasya");
//        user.setLastName("Dima");
//
//        var transaction = session.beginTransaction();
//        session.saveOrUpdate(user);
//        transaction.commit();
    }

    public List<User> getAllUsers() {
        return userRepository.getAllBy().orElseThrow();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Integer deleteUserById(Long id) {
        return userRepository.deleteUserById(id).orElseThrow();
    }
}

package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.repositories.PhoneRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepo phoneRepository;
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        Phone phone = new Phone();
        phone.setName("Sony Ericson");
        phone.setCreationYear(2005);

        var transaction = session.beginTransaction();
        session.saveOrUpdate(phone);
        transaction.commit();
    }

    public List<Phone> getAllPhones() {
        return phoneRepository.getAllBy().orElseThrow();
    }

    public void addPhone(Phone phone) {
        phoneRepository.save(phone);
    }

    public Integer deletePhoneById(Long id) {
        return phoneRepository.deleteUserById(id).orElseThrow();
    }
}

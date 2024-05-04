package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.repositories.PhoneRepo;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PhoneService {
    private final PhoneRepo phoneRepository;
//    private final SessionFactory sessionFactory;
//    private Session session;
//    @PostConstruct
//    void init() {
//        session = sessionFactory.openSession();
//    }

    public Manufacture getManufactureByPhone(Long phoneId) {
        log.info("Get manufacture by phone");
        return phoneRepository.findById(phoneId).orElseThrow().getManufacture();
    }

    public List<Phone> getPhonesByName(String name) {
        log.info("Get phone by name {}", name);
        return phoneRepository.findAllByName(name).orElseThrow();
    }

    public List<Phone> getAllPhones() {
        log.info("Get all phones");
        return phoneRepository.getAllBy().orElseThrow();
    }

    public void addPhone(Phone phone) {
        log.info("Add phone {} to db", phone);
        phoneRepository.save(phone);
    }

    public Integer deletePhoneById(Long id) {
        log.info("Delete phone by id {}", id);
        return phoneRepository.deleteUserById(id).orElseThrow();
    }

//    Фильтрация (сортировка) данных
    public List<Phone> sortPhones(String column) {
        log.info("Sort phones by order {}", column);
        return phoneRepository.findAll(Sort.by(Sort.Direction.ASC, column));
    }
}

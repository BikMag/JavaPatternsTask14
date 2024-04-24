package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.repositories.PhoneRepo;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
//        Phone phone = new Phone();
//        phone.setName("Sony Ericson");
//        phone.setCreationYear(2005);
//
//        var transaction = session.beginTransaction();
//        session.saveOrUpdate(phone);
//        transaction.commit();
    }

    public Manufacture getManufactureByPhone(Long phoneId) {
        return session.createQuery("from Phone where id =: id", Phone.class)
                .setParameter("id", phoneId).getSingleResult().getManufacture();
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

//    Фильтрация (сортировка) данных
    public List<Phone> sortPhones(String column) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> phoneCriteriaQuery =
                builder.createQuery(Phone.class);
        Root<Phone> root = phoneCriteriaQuery.from(Phone.class);

        phoneCriteriaQuery.select(root).orderBy(builder.asc(root.get(column)));
        Query<Phone> query = session.createQuery(phoneCriteriaQuery);
        return query.getResultList();
    }
}

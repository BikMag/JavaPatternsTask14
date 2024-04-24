package com.example.JavaPatternsTask14.services;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.repositories.ManufactureRepo;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufactureService {
    private final ManufactureRepo manufactureRepository;
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
//        Manufacture manufacture = new Manufacture();
//        manufacture.setName("Samsung Red Sun Factory");
//        manufacture.setAddress("Beijing, China");
//
//        var transaction = session.beginTransaction();
//        session.saveOrUpdate(manufacture);
//        transaction.commit();
    }

    public List<Manufacture> getAllManufactures() {
        log.info("Get all manufactures");
        return manufactureRepository.getAllBy().orElseThrow();
    }

    public void addManufacture(Manufacture manufacture) {
        log.info("Add manufacture {} in db", manufacture);
        manufactureRepository.save(manufacture);
    }

    public Integer deleteManufactureById(Long id) {
        log.info("Delete manufacture by id {}", id);
        return manufactureRepository.deleteUserById(id).orElseThrow();
    }

//  Фильтрация (сортировка) данных
    public List<Manufacture> sortManufactures(String column) {
        log.info("Sort manufactures by order {}", column);
        return manufactureRepository.findAll(Sort.by(Sort.Direction.ASC, column));
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Manufacture> manufactureCriteriaQuery =
//                builder.createQuery(Manufacture.class);
//        Root<Manufacture> root = manufactureCriteriaQuery.from(Manufacture.class);
//
//        manufactureCriteriaQuery.select(root).orderBy(builder.asc(root.get(column)));
//        Query<Manufacture> query = session.createQuery(manufactureCriteriaQuery);
//        return query.getResultList();
    }
}

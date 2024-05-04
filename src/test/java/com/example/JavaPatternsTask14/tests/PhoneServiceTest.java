package com.example.JavaPatternsTask14.tests;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.models.Phone;
import com.example.JavaPatternsTask14.repositories.PhoneRepo;
import com.example.JavaPatternsTask14.services.PhoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PhoneServiceTest {
    @Mock
    private PhoneRepo phoneRepository;

    @InjectMocks
    private PhoneService phoneService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetManufactureByPhone() {
        Phone phone = new Phone();
        Manufacture manufacture = new Manufacture();
        phone.setManufacture(manufacture);

        when(phoneRepository.findById(1L)).thenReturn(Optional.of(phone));
        Manufacture result = phoneService.getManufactureByPhone(1L);
        assertEquals(manufacture, result);
    }

    @Test
    public void testGetPhonesByName() {
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phones.add(phone);

        when(phoneRepository.findAllByName("Nokia")).thenReturn(Optional.of(phones));
        List<Phone> result = phoneService.getPhonesByName("Nokia");
        assertEquals(phones, result);
    }

    @Test
    public void testGetAllPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone());
        phones.add(new Phone());

        when(phoneRepository.getAllBy()).thenReturn(Optional.of(phones));
        List<Phone> result = phoneService.getAllPhones();
        assertEquals(phones, result);
    }

    @Test
    public void testAddPhone() {
        Phone phone = new Phone(1L, "iPhone 12", 2019,
                new Manufacture(2L, "name", "address", List.of()));

        phoneService.addPhone(phone);
        verify(phoneRepository).save(phone);
    }

    @Test
    public void testDeletePhoneById() {
        Long phoneId = 1L;

        when(phoneRepository.deleteUserById(phoneId)).thenReturn(Optional.of(1));
        Integer result = phoneService.deletePhoneById(phoneId);
        assertNotNull(result);
    }

    @Test
    public void testSortPhones() {
        Manufacture manufacture = new Manufacture(2L, "name", "address", List.of());

        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1L, "iPhone 12", 2019, manufacture));
        phones.add(new Phone(2L, "Samsung Galaxy S21", 2015, manufacture));
        phones.add(new Phone(3L, "Google Pixel 5", 2012, manufacture));

        String column = "id";

        List<Phone> sortedPhones = phones.stream().sorted(Comparator.comparing(Phone::getId)).toList();
        when(phoneRepository.findAll(Sort.by(Sort.Direction.ASC, column))).thenReturn(phones);
        List<Phone> result = phoneService.sortPhones(column);
        assertEquals(sortedPhones, result);
    }
}

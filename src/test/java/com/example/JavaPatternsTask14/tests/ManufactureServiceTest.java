package com.example.JavaPatternsTask14.tests;

import com.example.JavaPatternsTask14.models.Manufacture;
import com.example.JavaPatternsTask14.repositories.ManufactureRepo;
import com.example.JavaPatternsTask14.services.ManufactureService;
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

public class ManufactureServiceTest {
    @Mock
    private ManufactureRepo manufactureRepository;

    @InjectMocks
    private ManufactureService manufactureService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllManufactures() {
        List<Manufacture> manufactures = new ArrayList<>();
        manufactures.add(new Manufacture());
        manufactures.add(new Manufacture());

        when(manufactureRepository.getAllBy()).thenReturn(Optional.of(manufactures));
        List<Manufacture> result = manufactureService.getAllManufactures();
        assertEquals(manufactures, result);
    }

    @Test
    public void testAddManufacture() {
        Manufacture manufacture = new Manufacture(1L, "Apple factory", "Dallas", List.of());

        manufactureService.addManufacture(manufacture);
        verify(manufactureRepository).save(manufacture);
    }

    @Test
    public void testDeleteManufactureById() {
        Long manufactureId = 1L;

        when(manufactureRepository.deleteUserById(manufactureId)).thenReturn(Optional.of(1));
        Integer result = manufactureService.deleteManufactureById(manufactureId);
        assertNotNull(result);
    }

    @Test
    public void testSortManufactures() {
        List<Manufacture> manufactures = new ArrayList<>();
        manufactures.add(new Manufacture(1L, "Apple factory", "Dallas", List.of()));
        manufactures.add(new Manufacture(2L, "Samsung inc.", "Taiwan", List.of()));
        manufactures.add(new Manufacture(3L, "Google", "Los-Angeles", List.of()));

        String column = "id";

        List<Manufacture> sortedManufactures = manufactures.stream()
                .sorted(Comparator.comparing(Manufacture::getId)).toList();
        when(manufactureRepository.findAll(Sort.by(Sort.Direction.ASC, column))).thenReturn(manufactures);
        List<Manufacture> result = manufactureService.sortManufactures(column);
        assertEquals(sortedManufactures, result);
    }
}

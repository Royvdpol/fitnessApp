package com.ilionx.fitness.service;

import com.ilionx.fitness.model.Dumbbell;
import com.ilionx.fitness.persistence.FitnessRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DumbbellServiceTest {

    @InjectMocks
    private DumbbellService dumbbellService;

    @Mock
    private FitnessRepository fitnessRepository;

    public DumbbellServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Dumbbell mockedDumbbell = new Dumbbell();
        mockedDumbbell.setId(10L);
        mockedDumbbell.setWeight(50);
        Optional<Dumbbell> mockedOptionalDumbbell = Optional.of(mockedDumbbell);
        Mockito.when(this.fitnessRepository.findById(10L)).thenReturn(mockedOptionalDumbbell);

        Optional<Dumbbell> optionalDumbbell = this.dumbbellService.findById(10L);

        Assertions.assertEquals(10L, optionalDumbbell.get().getId());
        Assertions.assertEquals(50, optionalDumbbell.get().getWeight());
    }

    @Test
    void testSave() {
        Dumbbell dumbbell = new Dumbbell();
        dumbbell.setId(1L);
        dumbbell.setMaterial("Aluminum");
        Mockito.when(this.fitnessRepository.save(dumbbell)).thenReturn(dumbbell);

        Dumbbell savedDumbbell = this.dumbbellService.save(dumbbell);

        Mockito.verify(this.fitnessRepository).save(dumbbell);
        Assertions.assertEquals(1L, savedDumbbell.getId());
        Assertions.assertEquals("Aluminum", savedDumbbell.getMaterial());
    }

    @Test
    void testDelete() {
        Dumbbell dumbbell = new Dumbbell();
        dumbbell.setId(50L);
        dumbbell.setWeight(5);
        dumbbell.setMaterial("Wood");
        Mockito.when(this.fitnessRepository.save(dumbbell)).thenReturn(dumbbell);

        this.dumbbellService.deleteById(50L);

        Assertions.assertEquals(50L, dumbbell.getId());
    }
}
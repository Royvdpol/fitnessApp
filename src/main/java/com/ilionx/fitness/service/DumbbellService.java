package com.ilionx.fitness.service;

import com.ilionx.fitness.model.Dumbbell;
import com.ilionx.fitness.persistence.FitnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DumbbellService {

    private final FitnessRepository fitnessRepository;

    public DumbbellService(FitnessRepository fitnessRepository) {
        this.fitnessRepository = fitnessRepository;
    }

    public List<Dumbbell> findAll() {
        return fitnessRepository.findAll();
    }

    public Dumbbell save(Dumbbell entity) {
        return fitnessRepository.save(entity);
    }

    public Optional<Dumbbell> findById(Long id) {
        return fitnessRepository.findById(id);
    }

    public void deleteById(long id) {
        fitnessRepository.deleteById(id);
    }
}

package com.ilionx.fitness.service;

import com.ilionx.fitness.model.Dumbbell;
import com.ilionx.fitness.persistence.FitnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DumbbellService {

    @Autowired
    private FitnessRepository fitnessRepository;

    public List<Dumbbell> findAll() {
        return fitnessRepository.findAll();
    }

    public Dumbbell save(Dumbbell entity) {
        return fitnessRepository.save(entity);
    }

    public Optional<Dumbbell> findById(Long aLong) {
        return fitnessRepository.findById(aLong);
    }

    public long count() {
        return fitnessRepository.count();
    }

    public void deleteById(long id) {
        fitnessRepository.deleteById(id);
    }
}

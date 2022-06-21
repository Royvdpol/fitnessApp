package com.ilionx.fitness.persistence;

import com.ilionx.fitness.model.Dumbbell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessRepository extends JpaRepository<Dumbbell, Long> {
}

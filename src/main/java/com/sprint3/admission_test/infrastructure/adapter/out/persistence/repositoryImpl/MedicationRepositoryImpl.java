package com.sprint3.admission_test.infrastructure.adapter.out.persistence.repositoryImpl;

import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicationRepositoryImpl implements IMedicationRepository {

    @Autowired
    private MedicationJpaRepository medicationJpaRepository;

    @Override
    public Optional<Medication> findById(Long id) {
        return medicationJpaRepository.findById(id);
    }

    public Optional<Medication> findByName(String name) {
        return medicationJpaRepository.findByName(name);
    }

    public List<Medication> findByCategory(Long categoryId, LocalDate expirationDate){
        return medicationJpaRepository.findByCategory(categoryId, expirationDate);
    }

    public Medication create(Medication medication){
        return medicationJpaRepository.save(medication);
    }
}

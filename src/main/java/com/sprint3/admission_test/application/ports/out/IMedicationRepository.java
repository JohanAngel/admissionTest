package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMedicationRepository {
    Optional<Medication> findById(Long id);
    Optional<Medication> findByName(String id);
    List<Medication> findByCategory(Long categoryId, LocalDate expirationDate);
    Medication create(Medication medication);
}

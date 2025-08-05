package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.Dto.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    Optional<Medication> getMedicationByName(String name);
    List<Medication> getMedicationByCategory(Long category_id, LocalDate expirationDate);
    Medication create(MedicationDto medicationDto) throws Exception;
}

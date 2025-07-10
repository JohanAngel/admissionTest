package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);

    Medication createMedication(Medication medication);

    List<Medication> getMedicationsByCategoyAndAfterExpirationDate(String category, LocalDate expirationAfter);
}

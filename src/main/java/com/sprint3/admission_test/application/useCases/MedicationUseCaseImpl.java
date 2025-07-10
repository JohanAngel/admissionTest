package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.ExpirationDateIsBeforeToday;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    private final IMedicationRepository medicationRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public Medication createMedication(Medication medication) {
        LocalDate today = LocalDate.now();

        if (medication.getExpirationDate().isBefore(today)) {
            throw new ExpirationDateIsBeforeToday(medication.getExpirationDate(), today);
        }

        Category category = categoryRepository.findByName(medication.getCategory().getName())
                .orElseThrow(() -> new NotFoundException("Could not find category with name: " + medication.getCategory().getName()));

        medication.setCategory(category);
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getMedicationsByCategoyAndAfterExpirationDate(String category, LocalDate expirationAfter) {
        Category categoryModel = categoryRepository.findByName(category)
                .orElseThrow(() -> new NotFoundException("Could not find category with name: " + category));
        return medicationRepository.findAllByCategoyIdAndAfterExpirationDate(categoryModel.getId(), expirationAfter);
    }
}

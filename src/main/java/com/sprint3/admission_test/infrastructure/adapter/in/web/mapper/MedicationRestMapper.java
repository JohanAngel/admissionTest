package com.sprint3.admission_test.infrastructure.adapter.in.web.mapper;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.in.web.dto.MedicationCreateDto;

public class MedicationRestMapper {
    public static Medication mapToMedication(MedicationCreateDto medicationCreateDto, Medication medication) {
        medication.setName(medicationCreateDto.getName());
        medication.setDescription(medicationCreateDto.getDescription());
        medication.setPrice(medicationCreateDto.getPrice());
        medication.setExpirationDate(medicationCreateDto.getExpirationDate());
        medication.setCategory(new Category());
        medication.getCategory().setName(medicationCreateDto.getCategory_name());

        return medication;
    }
}

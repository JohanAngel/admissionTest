package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.in.web.dto.MedicationCreateDto;
import com.sprint3.admission_test.infrastructure.adapter.in.web.mapper.MedicationRestMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@Valid @RequestBody MedicationCreateDto medicationCreateDto) {
        Medication medicationCreated = medicationUseCase.createMedication(MedicationRestMapper.mapToMedication(medicationCreateDto, new Medication()));
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationCreated);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Medication>> getMedicationsByCategoyAndAfterExpirationDate(@PathVariable String category, @RequestParam LocalDate expiration_after) {
        List<Medication> medicationList = medicationUseCase.getMedicationsByCategoyAndAfterExpirationDate(category, expiration_after);
        return ResponseEntity.status(HttpStatus.OK).body(medicationList);
    }
}

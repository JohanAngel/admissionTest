package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.Dto.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<Medication>> getMedicationByCategory(@PathVariable Long category_id, @RequestParam String expiration){
        LocalDate localDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationByCategory(category_id, localDate));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MedicationDto medicationDto){
        try{
            return ResponseEntity.status(HttpStatus.FOUND).body(medicationUseCase.create(medicationDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FOUND).body(e.getMessage());
        }
    }

}

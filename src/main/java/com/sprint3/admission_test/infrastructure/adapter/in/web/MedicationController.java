package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.service.MedicationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.sprint3.admission_test.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired  
    private IMedicationUseCase medicationUseCase;
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expirationDate;
    private Category category;

    @Autowired
    private MedicationService medicationService;  // Servicio inyectado

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }
   
    @PostMapping("/addmedications")
    public ResponseEntity<Medication> addMedication(@RequestBody Medication newMedication) {
        Medication savedMedication = medicationService.addMedication(newMedication);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedication);
    }


    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }
    
}

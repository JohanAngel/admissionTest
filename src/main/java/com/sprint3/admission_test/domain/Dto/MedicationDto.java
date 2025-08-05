package com.sprint3.admission_test.domain.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MedicationDto {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expiration_date;
    private String category_name;
}

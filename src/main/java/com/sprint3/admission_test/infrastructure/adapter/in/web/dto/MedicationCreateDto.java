package com.sprint3.admission_test.infrastructure.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationCreateDto {

    @NotEmpty(message = "name can not be a null or empty")
    @Size(min = 5, max = 100, message = "The length of the name should be between 5 and 100")
    private String name;

    @NotEmpty(message = "description can not be a null or empty")
    @Size(min = 30, max = 255, message = "The length of the name should be between 30 and 255")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.00", inclusive = false, message = "The amount must be greater than zero.")
    @Digits(integer = 10, fraction = 2, message = "The amount must have at most 10 integer digits and 2 fraction digits.")
    private BigDecimal price;

    @NotNull(message = "Expiration date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @NotEmpty(message = "category_name can not be a null or empty")
    @Size(min = 3, max = 50, message = "The length of the name should be between 3 and 50")
    private String category_name;
}

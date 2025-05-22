package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

     // Método para buscar un medicamento por su ID
    Optional<Medication> findById(Long id);

    // Método para guardar un medicamento
    Medication save(Medication medication);

}

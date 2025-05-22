package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sprint3.admission_test.domain.model.Category;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

    // Método para buscar un medicamento por su ID
    Optional<Medication> findById(Long id);

    // Método para guardar un medicamento
    Medication save(Medication medication);

    // Consulta personalizada para encontrar medicamentos de una categoría que caducarán después de una fecha
    @Query("SELECT m FROM Medication m WHERE m.category = :category AND m.expirationDate > :expirationDate")
    List<Medication> findByCategoryAndExpirationDateAfter(Category category, LocalDate expirationDate);

}

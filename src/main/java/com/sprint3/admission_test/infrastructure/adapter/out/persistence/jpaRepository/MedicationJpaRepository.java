package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

    @Query(value = "SELECT * FROM medications WHERE category_id = ?1 AND expiration_date >= ?2", nativeQuery = true)
    List<Medication> findByCategory(Long categoryId, LocalDate expirationDate);

    @Query(value = "SELECT * FROM medications WHERE name = ?1", nativeQuery = true)
    Optional<Medication> findByName(String name);
}

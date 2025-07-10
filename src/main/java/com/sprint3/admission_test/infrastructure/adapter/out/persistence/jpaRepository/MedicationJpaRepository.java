package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {
    /*@Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<Article> findAllWithCreationDateTimeB(
            @Param("creationDateTime") Date creationDateTime);*/

    @Query("select m from Medication m where m.category.id = :categoryId and m.expirationDate > :expirationDate")
    List<Medication> findAllByCategoyIdAndAfterExpirationDate(@Param("categoryId") Long categoryId, @Param("expirationDate") LocalDate expirationDate);
}

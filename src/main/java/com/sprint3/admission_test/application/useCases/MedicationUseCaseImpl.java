package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.Dto.MedicationDto;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Autowired
    private ICate;


    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public Optional<Medication> getMedicationByName(String name) {
        return medicationRepository.findByName(name);
    }

    @Override
    public List<Medication> getMedicationByCategory(Long categoryId, LocalDate expirationDate){
        return medicationRepository.findByCategory(categoryId, expirationDate);
    }

    @Override
    public Medication create(MedicationDto medicationDto) throws Exception {
        Optional<Medication> find =  medicationRepository.findByName(medicationDto.getName());
        if(find.isPresent()){
            throw new Exception("Medicine already exists");
        }else {

            Medication medication = new Medication();
            medication.setName(medicationDto.getName());
            medication.setPrice(medicationDto.getPrice());
            medication.setDescription(medicationDto.getDescription());
            medication.getCategory()

            return medicationRepository.create(medication);
        }
    }
}

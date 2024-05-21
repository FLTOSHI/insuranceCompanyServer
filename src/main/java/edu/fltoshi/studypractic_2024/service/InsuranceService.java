package edu.fltoshi.studypractic_2024.service;

import edu.fltoshi.studypractic_2024.entity.InsuranceEntity;
import edu.fltoshi.studypractic_2024.repository.InsuranceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InsuranceService {
    private final InsuranceRepository repository;

    public List<InsuranceEntity> findAll() {
        return repository.findAll();
    }

    public Optional<InsuranceEntity> findById(Long id) {
        return repository.findById(id);
    }

    public InsuranceEntity save(InsuranceEntity data) {
        return repository.save(data);
    }

    public List<InsuranceEntity> getPricing (Integer cost) {
        return repository.findAllByCost(cost);
    }

    public void update(InsuranceEntity data) {
        repository.save(data);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

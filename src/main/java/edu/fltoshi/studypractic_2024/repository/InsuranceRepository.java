package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {

    List<InsuranceEntity> getAllByCost(Integer cost);
    List<InsuranceEntity> findAllByCost(Integer cost);
}
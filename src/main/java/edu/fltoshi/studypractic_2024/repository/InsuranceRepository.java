package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
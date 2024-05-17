package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
}
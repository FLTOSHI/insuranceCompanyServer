package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    List<ContractEntity> findAllByTimelapse(String timelapse);
}
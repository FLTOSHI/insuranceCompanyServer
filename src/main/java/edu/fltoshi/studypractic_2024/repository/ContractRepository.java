package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    List<ContractEntity> getAllByTimelapse(String timelapse);
}
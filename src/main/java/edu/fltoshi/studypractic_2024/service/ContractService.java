package edu.fltoshi.studypractic_2024.service;

import edu.fltoshi.studypractic_2024.entity.ContractEntity;
import edu.fltoshi.studypractic_2024.repository.ContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractService {
    private final ContractRepository repository;

    public List<ContractEntity> findAll() {
        return repository.findAll();
    }

    public Optional<ContractEntity> findById(Long id) {
        return repository.findById(id);
    }

    public List<ContractEntity> getTimelapses(String timelapse) {
        return repository.findAllByTimelapse(timelapse);}

    public ContractEntity save (ContractEntity data){
        return repository.save(data);
    }

    public void update (ContractEntity data){
        repository.save(data);
    }

    public void delete (Long id) {repository.deleteById(id);}

}

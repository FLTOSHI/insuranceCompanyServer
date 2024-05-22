package edu.fltoshi.studypractic_2024.service;

import edu.fltoshi.studypractic_2024.entity.ClientEntity;
import edu.fltoshi.studypractic_2024.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    public List<ClientEntity> findAll() {
        return (List<ClientEntity>) repository.findAll();
    }

    public Optional<ClientEntity> findById(Long id) {
        return repository.findById(id);
    }

    public List<ClientEntity> getById(Long id) {
        return repository.getById(id);
    }

    public List<ClientEntity> getAllByOsago(Boolean osago){
        return repository.getAllByOsago(osago);
    }

    public List<ClientEntity> getAllByProperty(Boolean property){
        return repository.getAllByOsago(property);
    }

    public List<ClientEntity> getAllByMedical(Boolean medical){
        return repository.getAllByOsago(medical);
    }

    public List<ClientEntity> getAllByLife(Boolean life){
        return repository.getAllByOsago(life);
    }

    public ClientEntity save(ClientEntity data) {
        return repository.save(data);
    }

    public void update(ClientEntity data) {
        repository.save(data);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

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
        return repository.findAll();
    }

    public Optional<ClientEntity> findById(Long id) {
        return repository.findById(id);
    }

    public ClientEntity save (ClientEntity data){
        return repository.save(data);
    }

    public void update (ClientEntity data){
        repository.save(data);
    }
}

package edu.fltoshi.studypractic_2024.service;

import edu.fltoshi.studypractic_2024.entity.UserEntity;
import edu.fltoshi.studypractic_2024.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<UserEntity> findAll() {
        return (List<UserEntity>) repository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return repository.findById(id);
    }

    public UserEntity save (UserEntity data){
        return repository.save(data);
    }

    public void update (UserEntity data){
        repository.save(data);
    }

    public void delete (Long id) {repository.deleteById(id);}

    public Optional<UserEntity> checkUser(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }
}

package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username,String password);
}
package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
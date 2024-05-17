package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
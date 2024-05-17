package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}

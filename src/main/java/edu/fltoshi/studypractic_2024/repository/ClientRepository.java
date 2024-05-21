package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    List<ClientEntity> findAllByOsago(Boolean osago);

    List<ClientEntity> findAllByProperty(Boolean property);

    List<ClientEntity> findAllByMedical(Boolean medical);

    List<ClientEntity> findAllByIdLife(Boolean life);

}

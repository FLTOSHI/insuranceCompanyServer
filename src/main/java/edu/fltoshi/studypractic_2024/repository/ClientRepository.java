package edu.fltoshi.studypractic_2024.repository;

import edu.fltoshi.studypractic_2024.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    List<ClientEntity> getAllByOsago(Boolean osago);

    List<ClientEntity> getAllByProperty(Boolean property);

    List<ClientEntity> getAllByMedical(Boolean medical);

    List<ClientEntity> getAllByLife(Boolean life);

    List<ClientEntity> getById(Long id);

}

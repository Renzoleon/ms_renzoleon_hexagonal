package com.rlb.ms_leonbautista_hexagonal.infraestructure.dao;

import com.rlb.ms_leonbautista_hexagonal.infraestructure.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity,Long> {

    EmpleadoEntity findEmpleadoEntityByNumDoc(String numDoc);
    Optional<EmpleadoEntity> findById(Long id);

}

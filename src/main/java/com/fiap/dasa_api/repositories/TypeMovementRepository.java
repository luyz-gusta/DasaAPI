package com.fiap.dasa_api.repositories;

import com.fiap.dasa_api.domain.entities.TypeMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeMovementRepository extends JpaRepository<TypeMovement, Long> {
    List<TypeMovement> findAllByStatusTrue();
}

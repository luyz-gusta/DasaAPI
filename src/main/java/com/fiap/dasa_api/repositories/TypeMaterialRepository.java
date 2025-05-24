package com.fiap.dasa_api.repositories;

import com.fiap.dasa_api.domain.entities.TypeMaterial;
import com.fiap.dasa_api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeMaterialRepository extends JpaRepository<TypeMaterial, Long> {
    List<TypeMaterial> findAllByStatusTrue();
}

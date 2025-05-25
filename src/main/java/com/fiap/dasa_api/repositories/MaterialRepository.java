package com.fiap.dasa_api.repositories;

import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findAllByStatusTrue();
}

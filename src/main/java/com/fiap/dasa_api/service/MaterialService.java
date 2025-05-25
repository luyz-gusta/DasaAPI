package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.repositories.MaterialRepository;
import com.fiap.dasa_api.repositories.TypeMaterialRepository;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaterialService {
    private final MaterialRepository repository;
    private final TypeMaterialRepository typeMaterialRepository;
    private final UserRepository userRepository;

    public List<Material> listAllMaterial() {
        return repository
                .findAll();
    }


    public List<Material> listMaterialActive() {
        return repository
                .findAllByStatusTrue();
    }

    public Material listMaterialById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Material saveMaterial(RequestMaterialDTO materialDTO) {
        User user = userRepository.findById(materialDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        TypeMaterial typeMaterial = typeMaterialRepository.findById(materialDTO.getIdTypeMaterial()).orElseThrow(EntityNotFoundException::new);

        Material newMaterial = new Material(materialDTO, user, typeMaterial);

        repository.save(newMaterial);
        return newMaterial;
    }

    @Transactional
    public Material editMaterial(UpdateMaterialDTO materialDTO) {
        User user = userRepository.findById(materialDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        TypeMaterial typeMaterial = typeMaterialRepository.findById(materialDTO.getIdTypeMaterial()).orElseThrow(EntityNotFoundException::new);
        Material material = repository
                .findById(materialDTO.getId())
                .orElseThrow(EntityNotFoundException::new);

        material.setUpdateMaterial(materialDTO, user, typeMaterial);
        return material;
    }

    @Transactional
    public void excludeMaterial(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

}

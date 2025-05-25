package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.typeMaterial.RequestTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.typeMaterial.UpdateTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.repositories.TypeMaterialRepository;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeMaterialService {
    private final TypeMaterialRepository repository;
    private final UserRepository userRepository;

    public List<TypeMaterial> listAllTypeMaterial() {
        return repository
                .findAll();
    }


    public List<TypeMaterial> listTypesMaterialActive() {
        return repository
                .findAllByStatusTrue();
    }

    public TypeMaterial listTypeMaterialById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public TypeMaterial saveTypeMaterial(RequestTypeMaterialDTO typeMaterialDTO) {
        User user = userRepository.findById(typeMaterialDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);

        TypeMaterial newTypeMaterial = new TypeMaterial(typeMaterialDTO, user);

        repository.save(newTypeMaterial);
        return newTypeMaterial;
    }

    @Transactional
    public TypeMaterial editTypeMaterial(UpdateTypeMaterialDTO typeMaterialDTO) {
        User user = userRepository.findById(typeMaterialDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);
        TypeMaterial typeMaterial = repository
                .findById(typeMaterialDTO.getId())
                .orElseThrow(EntityNotFoundException::new);



        typeMaterial.setUpdateTypeMaterial(typeMaterialDTO,user);
        return typeMaterial;
    }

    @Transactional
    public void excludeTypeMaterial(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

}

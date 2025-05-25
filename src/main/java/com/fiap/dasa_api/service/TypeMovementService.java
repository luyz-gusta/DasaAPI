package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.typeMovement.RequestTypeMovementDTO;
import com.fiap.dasa_api.domain.dto.typeMovement.UpdateTypeMovementDTO;
import com.fiap.dasa_api.domain.entities.TypeMovement;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.repositories.TypeMovementRepository;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeMovementService {
    private final TypeMovementRepository repository;
    private final UserRepository userRepository;

    public List<TypeMovement> listAllTypeMovement() {
        return repository
                .findAll();
    }


    public List<TypeMovement> listTypesMaterialActive() {
        return repository
                .findAllByStatusTrue();
    }

    public TypeMovement listTypeMovementById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public TypeMovement saveTypeMovement(RequestTypeMovementDTO TypeMovementDTO) {
        User user = userRepository.findById(TypeMovementDTO.getIdUser()).orElseThrow(EntityNotFoundException::new);

        TypeMovement newTypeMovement = new TypeMovement(TypeMovementDTO, user);

        repository.save(newTypeMovement);
        return newTypeMovement;
    }

    @Transactional
    public TypeMovement editTypeMovement(UpdateTypeMovementDTO TypeMovementDTO) {
        TypeMovement TypeMovement = repository
                .findById(TypeMovementDTO.getId())
                .orElseThrow(EntityNotFoundException::new);

        TypeMovement.setUpdateTypeMovement(TypeMovementDTO, TypeMovement.getUser());
        return TypeMovement;
    }

    @Transactional
    public void excludeTypeMovement(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

}

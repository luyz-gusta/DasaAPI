package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.infra.mappers.user.UserMapper;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    private void validEmail(String email) {
        Optional<User> existingUser = repository
                .findByEmail(email)
                .stream()
                .findFirst();
        if (existingUser.isPresent()) {
            throw new DuplicateKeyException("email");
        }
    }


    public List<ResponseUserDTO> listAllUsers() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
    }

    public List<ResponseUserDTO> listUsersActive() {
        return repository
                .findAllByStatusTrue()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
    }

    public ResponseUserDTO listUserById(Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toUserResponse(user);
    }

    public ResponseUserDTO saveUser(RequestUserDTO userDTO) {
        validEmail(userDTO.getEmail());

        User user = new User(userDTO);

        repository.save(user);
        return mapper.toUserResponse(user);
    }

    @Transactional
    public ResponseUserDTO editUser(UpdateUserDTO userDTO) {
        User user = repository
                .findById(userDTO.getId())
                .orElseThrow(EntityNotFoundException::new);

        user.setUpdatedUser(userDTO);
        return mapper.toUserResponse(user);
    }

    @Transactional
    public ResponseUserDTO editUserStatus(Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setStatus(!user.getStatus());

        return mapper.toUserResponse(user);
    }

    @Transactional
    public void excludeUser(Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

}

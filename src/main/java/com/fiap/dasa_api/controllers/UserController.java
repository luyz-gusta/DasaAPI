package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.infra.mappers.user.UserMapper;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name = "User")
public class UserController {
    private final UserRepository repository;
    private final UserMapper mapper;

    @GetMapping
    public ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsers() {
        List<ResponseUserDTO> users = repository
                .findAll()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
        return ResponseEntity.ok(ApiResponseBuilder.listSuccess(users));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsersByActive() {
        List<ResponseUserDTO> users = repository
                .findAllByStatusTrue()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
        return ResponseEntity.ok(ApiResponseBuilder.listSuccess(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> getUserById(@PathVariable Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        ResponseUserDTO userResponse = mapper.toUserResponse(user);

        return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(userResponse));
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> registerUser(@RequestBody @Valid RequestUserDTO userDTO) {
        try {
            User newUser = new User(userDTO);
            repository.save(newUser);

            ResponseUserDTO user = mapper.toUserResponse(newUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseBuilder.singleCreate(user));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> updateUser(@RequestBody @Valid UpdateUserDTO userDTO) {
        User user = repository.findById(userDTO.getId()).orElseThrow(EntityNotFoundException::new);
        User isExistingEmail = repository.findByEmail(userDTO.getEmail());

        if (!Objects.equals(isExistingEmail.getId(), userDTO.getId())) {
            throw new DuplicateKeyException("email");
        }

        user.setUpdatedUser(userDTO);
        ResponseUserDTO userResponse = mapper.toUserResponse(user);
        return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(userResponse));
    }

    @PutMapping("/toogle-status/{id}")
    @Transactional
    public ResponseEntity<ApiSingleResponse<ResponseUserDTO>> toogleStatus(@PathVariable Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setStatus(!user.getStatus());

        ResponseUserDTO userResponse = mapper.toUserResponse(user);
        return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(userResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        repository.findById(id).orElseThrow(EntityNotFoundException::new);

        repository.deleteById(id);
        return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
    }
}

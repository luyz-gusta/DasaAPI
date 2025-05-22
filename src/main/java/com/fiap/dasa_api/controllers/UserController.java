package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<User> allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody @Valid RequestUserDTO userDTO){
        User newUser = new User(userDTO);

        repository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUser(@RequestBody @Valid UpdateUserDTO userDTO){
        Optional<User> optionalUser = repository.findById(userDTO.getId());

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setUpdatedUser(userDTO);

            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        Optional<User> optionalUser = repository.findById(id);

        if(optionalUser.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}

package com.fiap.dasa_api.repositories;

import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatusTrue();
    User findByEmail(String email);
}

package com.fiap.dasa_api.service;

import com.fiap.dasa_api.domain.dto.auth.LoginRequestDTO;
import com.fiap.dasa_api.domain.dto.auth.LoginResponseDTO;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        // Busca o usuário pelo email
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Verifica se o usuário está ativo
        if (!user.getStatus()) {
            throw new IllegalStateException("Usuário inativo");
        }

        // Valida a senha
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Credenciais inválidas");
        }

        // Retorna os dados do usuário
        return LoginResponseDTO.builder()
                .userId(user.getId())
                .userName(user.getName())
                .email(user.getEmail())
                .registration(user.getRegistration())
                .photo(user.getPhoto())
                .status(user.getStatus())
                .build();
    }
}

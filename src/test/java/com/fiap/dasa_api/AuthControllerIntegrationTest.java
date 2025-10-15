package com.fiap.dasa_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.dasa_api.domain.dto.auth.LoginRequestDTO;
import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AuthControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    private LoginRequestDTO loginRequest;
    private RequestUserDTO userRequest;

    @BeforeEach
    void setUp() throws Exception {
        // Limpa o repositório antes de cada teste
        userRepository.deleteAll();

        // Cria um usuário de teste
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateBirth = sdf.parse("1990-01-01");

        userRequest = new RequestUserDTO();
        userRequest.setName("Test User");
        userRequest.setEmail("test@example.com");
        userRequest.setPassword("password123");
        userRequest.setDateBirth(dateBirth);
        userRequest.setRegistration("REG001");

        // Registra o usuário
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRequest)));

        // Prepara o request de login
        loginRequest = new LoginRequestDTO();
        loginRequest.setEmail("test@example.com");
        loginRequest.setPassword("password123");
    }

    @Test
    @DisplayName("Deve realizar login com sucesso")
    void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Requisição bem sucedida!"))
                .andExpect(jsonPath("$.data.userId").exists())
                .andExpect(jsonPath("$.data.userName").value("Test User"))
                .andExpect(jsonPath("$.data.email").value("test@example.com"))
                .andExpect(jsonPath("$.data.status").value(true));
    }

    @Test
    @DisplayName("Deve falhar ao fazer login com senha incorreta")
    void testLoginWithWrongPassword() throws Exception {
        loginRequest.setPassword("wrongpassword");

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    @DisplayName("Deve falhar ao fazer login com email não cadastrado")
    void testLoginWithNonExistentEmail() throws Exception {
        loginRequest.setEmail("nonexistent@example.com");

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    @DisplayName("Deve falhar ao fazer login sem email")
    void testLoginWithoutEmail() throws Exception {
        loginRequest.setEmail(null);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve falhar ao fazer login sem senha")
    void testLoginWithoutPassword() throws Exception {
        loginRequest.setPassword(null);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isBadRequest());
    }
}

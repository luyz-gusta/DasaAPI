package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.auth.LoginRequestDTO;
import com.fiap.dasa_api.domain.dto.auth.LoginResponseDTO;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.AuthService;
import com.fiap.dasa_api.specs.AuthControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController implements AuthControllerSpecs {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiSingleResponse<LoginResponseDTO>> login(
            @RequestBody @Valid LoginRequestDTO loginRequest
    ) {
        try {
            LoginResponseDTO response = authService.login(loginRequest);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(response));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}

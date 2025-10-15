package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.auth.LoginRequestDTO;
import com.fiap.dasa_api.domain.dto.auth.LoginResponseDTO;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Autenticação", description = "Endpoints para autenticação de usuários")
@ApiResponseInternalServerError
public interface AuthControllerSpecs {

        @Operation(summary = "Realizar login", description = "Autentica um usuário e retorna seus dados")
        @ApiResponseBadRequest
        @ApiResponseUnauthorized
        @ApiResponseNotFound
        @ResponseStatus(HttpStatus.OK)
        ResponseEntity<ApiSingleResponse<LoginResponseDTO>> login(
                        @RequestBody LoginRequestDTO loginRequest);
}

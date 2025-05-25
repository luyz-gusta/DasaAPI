package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.dto.user.UpdateUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Tag(name = "User", description = "User operations")
@ApiResponseInternalServerError
public interface UserControllerSpecs {

    @Operation(summary = "Find all users")
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<ResponseUserDTO>> getAllUsers();

    @Operation(summary = "Find user by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> getUserById(@PathVariable Long id);

    @Operation(summary = "Create user")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> registerUser(@RequestBody RequestUserDTO userDTO);

    @Operation(summary = "Updade user")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> updateUser(@RequestBody @Valid UpdateUserDTO userDTO);
}

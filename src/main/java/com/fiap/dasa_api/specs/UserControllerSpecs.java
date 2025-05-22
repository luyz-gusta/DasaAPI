package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.user.RequestUserDTO;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "1. User", description = "User operations")
@ApiResponseInternalServerError
public interface UserControllerSpecs {

    @Operation(summary = "Create user")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created")
    })
    @ApiResponse(responseCode = "201", description = "Created", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiMessageResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> create(@RequestBody RequestUserDTO body);


    @Operation(summary = "Find user by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ApiResponse(responseCode = "200", description = "User found successfully", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiSingleResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<ResponseUserDTO>> findById(@PathVariable Long id);


}

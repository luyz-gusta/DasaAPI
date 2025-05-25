package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.typeMovement.RequestTypeMovementDTO;
import com.fiap.dasa_api.domain.dto.typeMovement.UpdateTypeMovementDTO;
import com.fiap.dasa_api.domain.entities.TypeMovement;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
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

@Tag(name = "Type Movement", description = "Type movement operations")
@ApiResponseInternalServerError
public interface TypeMovementControllerSpecs {

    @Operation(summary = "Find all type movement")
    @ApiResponseForbidden
    @ApiResponse(responseCode = "200", description = "Type movement found successfully", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiSingleResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<TypeMovement>> getAllTypeMovement();

    @Operation(summary = "Find type movement by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ApiResponse(responseCode = "200", description = "Type movement found successfully", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiSingleResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TypeMovement>> getTypeMovementById(@PathVariable Long id);


    @Operation(summary = "Create type movement")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created")
    })
    @ApiResponse(responseCode = "201", description = "Created", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiSingleResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<TypeMovement>> createTypeMovement(@RequestBody RequestTypeMovementDTO typeMovementDTO);

    @Operation(summary = "Update type momevent")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TypeMovement>> updateTypeMovement(@RequestBody UpdateTypeMovementDTO typeMovementDTO);

    @Operation(summary = "Delete type momevent")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteTypeMovement(@PathVariable Long id);

}

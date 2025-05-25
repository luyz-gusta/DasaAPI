package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
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

@Tag(name = "Material", description = "Material operations")
@ApiResponseInternalServerError
public interface MaterialControllerSpecs {

    @Operation(summary = "Find all material")
    @ApiResponseForbidden
    @ApiResponse(responseCode = "200", description = "Material found successfully", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiListResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Material>> getAllMaterial();

    @Operation(summary = "Find material by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ApiResponse(responseCode = "200", description = "Material found successfully", content = {
            @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiSingleResponse.class)
            )
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Material>> getMaterialById(@PathVariable Long id);


    @Operation(summary = "Create material")
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
    ResponseEntity<ApiSingleResponse<Material>> createMaterial(@RequestBody RequestMaterialDTO body);

}

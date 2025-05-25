package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.typeMaterial.RequestTypeMaterialDTO;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
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

@Tag(name = "Type Material", description = "Type material operations")
@ApiResponseInternalServerError
public interface TypeMaterialControllerSpecs {

    @Operation(summary = "Find all type material")
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<TypeMaterial>> getAllTypeMaterial();

    @Operation(summary = "Find type material by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TypeMaterial>> getTypeMaterialById(@PathVariable Long id);


    @Operation(summary = "Create type material")
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
    ResponseEntity<ApiSingleResponse<TypeMaterial>> createTypeMaterial(@RequestBody RequestTypeMaterialDTO body);

}

package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.typeMaterial.RequestTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.typeMaterial.UpdateTypeMaterialDTO;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
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

@Tag(name = "Type Material", description = "Type material operations")
@ApiResponseInternalServerError
public interface TypeMaterialControllerSpecs {

    @Operation(summary = "Find all type material")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<TypeMaterial>> getAllTypeMaterial();

    @Operation(summary = "Find type material by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TypeMaterial>> getTypeMaterialById(@PathVariable Long id);


    @Operation(summary = "Create type material")
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<TypeMaterial>> createTypeMaterial(@RequestBody RequestTypeMaterialDTO typeMaterialDTOy);

    @Operation(summary = "Update type material")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<TypeMaterial>> updateTypeMaterial(@RequestBody UpdateTypeMaterialDTO typeMaterialDTOy);

    @Operation(summary = "Delete type material")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteTypeMaterial(@PathVariable Long id);

}

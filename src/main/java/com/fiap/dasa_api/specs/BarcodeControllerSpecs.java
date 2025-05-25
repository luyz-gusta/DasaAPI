package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.barcode.RequestBarcodeDTO;
import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.entities.Barcode;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.specs.error.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Barcode", description = "Barcode operations")
@ApiResponseInternalServerError
public interface BarcodeControllerSpecs {

    @Operation(summary = "Find all barcode")
    @ApiResponseForbidden
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Barcode>> getAllBarcode();

    @Operation(summary = "Find barcode by id")
    @ApiResponseNotFound
    @ApiResponseForbidden
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Barcode>> getBarcodeById(@PathVariable Long id);

    @Operation(summary = "Create barcode")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Barcode>> createBarcode(@RequestBody RequestBarcodeDTO body);

}

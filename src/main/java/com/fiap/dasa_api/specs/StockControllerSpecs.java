package com.fiap.dasa_api.specs;

import com.fiap.dasa_api.domain.dto.stock.RequestStockDTO;
import com.fiap.dasa_api.domain.dto.stock.UpdateStockDTO;
import com.fiap.dasa_api.domain.entities.Stock;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.specs.error.ApiResponseBadRequest;
import com.fiap.dasa_api.specs.error.ApiResponseDuplicatedResource;
import com.fiap.dasa_api.specs.error.ApiResponseInternalServerError;
import com.fiap.dasa_api.specs.error.ApiResponseNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Stock", description = "Stock operations")
@ApiResponseInternalServerError
public interface StockControllerSpecs {

    @Operation(summary = "Find all stock")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiListResponse<Stock>> getAllStock();

    @Operation(summary = "Find stock by id")
    @ApiResponseNotFound
    @ApiResponseBadRequest
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Stock>> getStockById(@PathVariable Long id);


    @Operation(summary = "Create stock")
    @ApiResponseBadRequest
    @ApiResponseDuplicatedResource
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ApiSingleResponse<Stock>> createStock(@RequestBody RequestStockDTO stockDTO);

    @Operation(summary = "Update stock")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiSingleResponse<Stock>> updateStock(@RequestBody UpdateStockDTO stockDTO);

    @Operation(summary = "Delete stock")
    @ApiResponseBadRequest
    @ApiResponseNotFound
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ApiMessageResponse> deleteStock(@PathVariable Long id);


}

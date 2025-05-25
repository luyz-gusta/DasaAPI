package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.stock.RequestStockDTO;
import com.fiap.dasa_api.domain.dto.stock.UpdateStockDTO;
import com.fiap.dasa_api.domain.entities.Stock;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.StockService;
import com.fiap.dasa_api.specs.StockControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/stock")
public class StockController implements StockControllerSpecs {
    private StockService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Stock>> getAllStock() {
        try {
            List<Stock> stocks = service.listAllStock();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(stocks));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Stock>> getStockById(@PathVariable Long id) {
            Stock stock = service.listStockById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(stock));
    }


    @PostMapping
    public ResponseEntity<ApiSingleResponse<Stock>> createStock(
            @RequestBody @Valid RequestStockDTO stockDTO) {
        try {
            Stock stock = service.saveStock(stockDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponseBuilder.singleCreate(stock)
            );
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    public ResponseEntity<ApiSingleResponse<Stock>> updateStock(
            @RequestBody @Valid UpdateStockDTO stockDTO) {
        try {
            Stock stock = service.editStock(stockDTO);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(stock));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteStock(@PathVariable Long id) {
        try {
            service.excludeStock(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}

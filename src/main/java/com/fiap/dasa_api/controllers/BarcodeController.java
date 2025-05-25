package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.barcode.RequestBarcodeDTO;
import com.fiap.dasa_api.domain.dto.barcode.UpdateBarcodeDTO;
import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import com.fiap.dasa_api.domain.entities.Barcode;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.BarcodeService;
import com.fiap.dasa_api.service.MaterialService;
import com.fiap.dasa_api.specs.BarcodeControllerSpecs;
import com.fiap.dasa_api.specs.MaterialControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/barcode")
public class BarcodeController implements BarcodeControllerSpecs {
    private BarcodeService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Barcode>> getAllBarcode() {
        try {
            List<Barcode> barcodes = service.listAllBarcode();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(barcodes));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Barcode>> getBarcodeById(@PathVariable Long id) {
        try {
            Barcode barcodes = service.listBarcodeById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(barcodes));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Barcode>> createBarcode(
            @RequestBody @Valid RequestBarcodeDTO barcodeDTO) {
        try {
            Barcode barcode = service.saveBarcode(barcodeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponseBuilder.singleCreate(barcode)
            );
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    public ResponseEntity<ApiSingleResponse<Barcode>> updateBarcode(
            @RequestBody @Valid UpdateBarcodeDTO barcodeDTO) {
        try {
            Barcode barcode = service.editBarcode(barcodeDTO);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(barcode));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteBarcode(@PathVariable Long id) {
        try {
            service.excludeBarcode(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}

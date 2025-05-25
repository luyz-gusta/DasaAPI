package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.typeMovement.RequestTypeMovementDTO;
import com.fiap.dasa_api.domain.dto.typeMovement.UpdateTypeMovementDTO;
import com.fiap.dasa_api.domain.entities.TypeMovement;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.TypeMovementService;
import com.fiap.dasa_api.specs.TypeMovementControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/type-movement")
public class TypeMovementController implements TypeMovementControllerSpecs {
    private TypeMovementService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<TypeMovement>> getAllTypeMovement() {
        try {
            List<TypeMovement> TypeMovements = service.listAllTypeMovement();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(TypeMovements));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<TypeMovement>> getTypeMovementById(@PathVariable Long id) {
        try {
            TypeMovement TypeMovements = service.listTypeMovementById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(TypeMovements));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<TypeMovement>> createTypeMovement(
            @RequestBody @Valid RequestTypeMovementDTO TypeMovementDTO) {
        try {
            TypeMovement TypeMovement = service.saveTypeMovement(TypeMovementDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponseBuilder.singleCreate(TypeMovement)
            );
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    public ResponseEntity<ApiSingleResponse<TypeMovement>> updateTypeMovement(
            @RequestBody @Valid UpdateTypeMovementDTO TypeMovementDTO) {
        try {
            TypeMovement TypeMovement = service.editTypeMovement(TypeMovementDTO);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(TypeMovement));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteTypeMovement(@PathVariable Long id) {
        try {
            service.excludeTypeMovement(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}

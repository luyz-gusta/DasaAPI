package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.typeMaterial.RequestTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.typeMaterial.UpdateTypeMaterialDTO;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.TypeMaterialService;
import com.fiap.dasa_api.specs.TypeMaterialControllerSpecs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/type-material")
public class TypeMaterialController implements TypeMaterialControllerSpecs {
    private TypeMaterialService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<TypeMaterial>> getAllTypeMaterial() {
        try {
            List<TypeMaterial> typeMaterials = service.listAllTypeMaterial();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(typeMaterials));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<TypeMaterial>> getTypeMaterialById(@PathVariable Long id) {
        try {
            TypeMaterial typeMaterials = service.listTypeMaterialById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(typeMaterials));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<TypeMaterial>> createTypeMaterial(
            @RequestBody @Valid RequestTypeMaterialDTO typeMaterialDTO) {
        try {
            TypeMaterial typeMaterial = service.saveTypeMaterial(typeMaterialDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponseBuilder.singleCreate(typeMaterial)
            );
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    public ResponseEntity<ApiSingleResponse<TypeMaterial>> updateTypeMaterial(
            @RequestBody @Valid UpdateTypeMaterialDTO typeMaterialDTO) {
        try {
            TypeMaterial typeMaterial = service.editTypeMaterial(typeMaterialDTO);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(typeMaterial));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteTypeMaterial(@PathVariable Long id) {
        try {
            service.excludeTypeMaterial(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}

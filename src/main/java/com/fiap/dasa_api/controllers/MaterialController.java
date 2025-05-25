package com.fiap.dasa_api.controllers;

import com.fiap.dasa_api.domain.dto.material.RequestMaterialDTO;
import com.fiap.dasa_api.domain.dto.material.UpdateMaterialDTO;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.infra.responses.ApiResponseBuilder;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.MaterialService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/material")
public class MaterialController {
    private MaterialService service;

    @GetMapping
    public ResponseEntity<ApiListResponse<Material>> getAllMaterial() {
        try {
            List<Material> materials = service.listAllMaterial();
            return ResponseEntity.ok(ApiResponseBuilder.listSuccess(materials));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSingleResponse<Material>> getMaterialById(@PathVariable Long id) {
        try {
            Material materials = service.listMaterialById(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleSuccess(materials));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PostMapping
    public ResponseEntity<ApiSingleResponse<Material>> createMaterial(
            @RequestBody @Valid RequestMaterialDTO materialDTO) {
        try {
            Material material = service.saveMaterial(materialDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponseBuilder.singleCreate(material)
            );
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @PutMapping
    public ResponseEntity<ApiSingleResponse<Material>> updateMaterial(
            @RequestBody @Valid UpdateMaterialDTO materialDTO) {
        try {
            Material material = service.editMaterial(materialDTO);
            return ResponseEntity.ok(ApiResponseBuilder.singleUpdate(material));
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> deleteMaterial(@PathVariable Long id) {
        try {
            service.excludeMaterial(id);
            return ResponseEntity.ok(ApiResponseBuilder.singleDelete());
        } catch (Exception exp) {
            throw new InternalException(exp);
        }
    }
}

package com.fiap.dasa_api;

import com.fiap.dasa_api.controllers.TypeMaterialController;
import com.fiap.dasa_api.domain.dto.typeMaterial.RequestTypeMaterialDTO;
import com.fiap.dasa_api.domain.dto.typeMaterial.UpdateTypeMaterialDTO;
import com.fiap.dasa_api.domain.entities.TypeMaterial;
import com.fiap.dasa_api.infra.errors.ExceptionDTO;
import com.fiap.dasa_api.infra.errors.exceptions.RequestExceptionHandler;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.TypeMaterialService;
import com.fiap.dasa_api.specs.error.ApiResponseNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TypeMaterialControllerTest {

    private TypeMaterialService typeMaterialService;
    private TypeMaterialController typeMaterialController;

    @BeforeEach
    void setUp() {
        typeMaterialService = mock(TypeMaterialService.class);
        typeMaterialController = new TypeMaterialController(typeMaterialService);
    }

    @Test
    void testGetAll() {
        List<TypeMaterial> mockList = Arrays.asList(new TypeMaterial(), new TypeMaterial());
        when(typeMaterialService.listAllTypeMaterial()).thenReturn(mockList);

        ResponseEntity<ApiListResponse<TypeMaterial>> response = typeMaterialController.getAllTypeMaterial();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetById_Found() {
        TypeMaterial typeMaterial = new TypeMaterial();
        when(typeMaterialService.listTypeMaterialById(1L)).thenReturn(typeMaterial);

        ResponseEntity<ApiSingleResponse<TypeMaterial>> response = typeMaterialController.getTypeMaterialById(1L);
        ApiSingleResponse<TypeMaterial> expected =
                new ApiSingleResponse<TypeMaterial>(200, "Requisição bem sucedida!", typeMaterial);


        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testGetById_NotFound() {
        ApiSingleResponse<TypeMaterial> expected =
                new ApiSingleResponse<TypeMaterial>(200, "Requisição bem sucedida!", null);
        when(typeMaterialService.listTypeMaterialById(15L)).thenReturn(null);

        ResponseEntity<ApiSingleResponse<TypeMaterial>> response = typeMaterialController.getTypeMaterialById(150L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testCreate() {
        RequestTypeMaterialDTO dto = new RequestTypeMaterialDTO();
        TypeMaterial typeMaterial = new TypeMaterial();
        when(typeMaterialService.saveTypeMaterial(dto)).thenReturn(typeMaterial);

        ResponseEntity<ApiSingleResponse<TypeMaterial>> response = typeMaterialController.createTypeMaterial(dto);
        ApiSingleResponse<TypeMaterial> expected =
                new ApiSingleResponse<TypeMaterial>(201, "Item criado com sucesso!", typeMaterial);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testUpdate() {
        UpdateTypeMaterialDTO dto = new UpdateTypeMaterialDTO();
        TypeMaterial typeMaterial = new TypeMaterial();
        when(typeMaterialService.editTypeMaterial(dto)).thenReturn(typeMaterial);

        ResponseEntity<ApiSingleResponse<TypeMaterial>> response = typeMaterialController.updateTypeMaterial(dto);
        ApiSingleResponse<TypeMaterial> expected =
                new ApiSingleResponse<TypeMaterial>(200, "Item atualizado com sucesso!", typeMaterial);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());

    }

    @Test
    void testDelete() {
        doNothing().when(typeMaterialService).excludeTypeMaterial(1L);

        ResponseEntity<ApiMessageResponse> response = typeMaterialController.deleteTypeMaterial(1L);
        ApiMessageResponse deleted = new ApiMessageResponse(200,"Item deletado com sucesso!");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(deleted, response.getBody());
    }
}

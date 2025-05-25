package com.fiap.dasa_api;

import com.fiap.dasa_api.controllers.TypeMovementController;
import com.fiap.dasa_api.domain.dto.typeMovement.RequestTypeMovementDTO;
import com.fiap.dasa_api.domain.dto.typeMovement.UpdateTypeMovementDTO;
import com.fiap.dasa_api.domain.entities.TypeMovement;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import com.fiap.dasa_api.infra.responses.details.ApiSingleResponse;
import com.fiap.dasa_api.service.TypeMovementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TypeMovementControllerTest {

    private TypeMovementService typeMovementService;
    private TypeMovementController typeMovementController;

    @BeforeEach
    void setUp() {
        typeMovementService = mock(TypeMovementService.class);
        typeMovementController = new TypeMovementController(typeMovementService);
    }

    @Test
    void testGetAll() {
        List<TypeMovement> mockList = Arrays.asList(new TypeMovement(), new TypeMovement());
        when(typeMovementService.listAllTypeMovement()).thenReturn(mockList);

        ResponseEntity<ApiListResponse<TypeMovement>> response = typeMovementController.getAllTypeMovement();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().getData().size());
    }

    @Test
    void testGetById_Found() {
        TypeMovement typeMovement = new TypeMovement();
        when(typeMovementService.listTypeMovementById(1L)).thenReturn(typeMovement);

        ResponseEntity<ApiSingleResponse<TypeMovement>> response = typeMovementController.getTypeMovementById(1L);
        ApiSingleResponse<TypeMovement> expected =
                new ApiSingleResponse<>(200, "Requisição bem sucedida!", typeMovement);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testGetById_NotFound() {
        when(typeMovementService.listTypeMovementById(150L)).thenReturn(null);

        ResponseEntity<ApiSingleResponse<TypeMovement>> response = typeMovementController.getTypeMovementById(150L);
        ApiSingleResponse<TypeMovement> expected =
                new ApiSingleResponse<>(200, "Requisição bem sucedida!", null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testCreate() {
        RequestTypeMovementDTO dto = new RequestTypeMovementDTO();
        TypeMovement typeMovement = new TypeMovement();
        when(typeMovementService.saveTypeMovement(dto)).thenReturn(typeMovement);

        ResponseEntity<ApiSingleResponse<TypeMovement>> response = typeMovementController.createTypeMovement(dto);
        ApiSingleResponse<TypeMovement> expected =
                new ApiSingleResponse<>(201, "Item criado com sucesso!", typeMovement);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testUpdate() {
        UpdateTypeMovementDTO dto = new UpdateTypeMovementDTO();
        TypeMovement typeMovement = new TypeMovement();
        when(typeMovementService.editTypeMovement(dto)).thenReturn(typeMovement);

        ResponseEntity<ApiSingleResponse<TypeMovement>> response = typeMovementController.updateTypeMovement(dto);
        ApiSingleResponse<TypeMovement> expected =
                new ApiSingleResponse<>(200, "Item atualizado com sucesso!", typeMovement);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }

    @Test
    void testDelete() {
        doNothing().when(typeMovementService).excludeTypeMovement(1L);

        ResponseEntity<ApiMessageResponse> response = typeMovementController.deleteTypeMovement(1L);
        ApiMessageResponse expected = new ApiMessageResponse(200, "Item deletado com sucesso!");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expected, response.getBody());
    }
}

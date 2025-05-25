package com.fiap.dasa_api;


import com.fiap.dasa_api.controllers.MaterialController;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.service.MaterialService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MaterialControllerUnitTest {

    @Test
    public void testGetAllMaterials() {
        // Arrange
        MaterialService mockService = Mockito.mock(MaterialService.class);
        MaterialController controller = new MaterialController(mockService);

        Material mockMaterial = new Material();
        mockMaterial.setId(1L);
        mockMaterial.setName("Álcool em gel");

        when(mockService.listAllMaterial()).thenReturn(List.of(mockMaterial));

        // Act
        ResponseEntity<ApiListResponse<Material>> response = controller.getAllMaterial();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Álcool em gel", response.getBody().getData().get(0).getName());

        verify(mockService, times(1)).listAllMaterial();
    }
}

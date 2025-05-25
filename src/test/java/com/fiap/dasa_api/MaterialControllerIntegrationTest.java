
package com.fiap.dasa_api;

import com.fiap.dasa_api.controllers.MaterialController;
import com.fiap.dasa_api.domain.entities.Material;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MaterialControllerIntegrationTest {

    @Autowired
    private MaterialController materialController;

    @Test
    public void testGetAllMaterials_withRealDatabase() {
        ResponseEntity<ApiListResponse<Material>> response = materialController.getAllMaterial();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        List<Material> materials = response.getBody().getData();
        assertNotNull(materials);
        assertFalse(materials.isEmpty(), "A lista de materiais deve conter pelo menos um item");

        Material first = materials.get(0);
        assertNotNull(first.getId());
        assertNotNull(first.getName());
    }
}

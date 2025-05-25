
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
    public void testGetAllMaterialsFromDatabase() {
        // Chama o método real do controller, que acessa o banco real
        ResponseEntity<ApiListResponse<Material>> response = materialController.getAllMaterial();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        List<Material> materiais = response.getBody().getData();
        assertFalse(materiais.isEmpty(), "A lista de materiais não deve estar vazia");

        // Você pode verificar um campo específico se quiser:
        // assertEquals("Álcool em gel", materiais.get(0).getName());
    }
}

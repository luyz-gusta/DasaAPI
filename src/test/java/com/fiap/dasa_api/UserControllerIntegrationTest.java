
package com.fiap.dasa_api;

import com.fiap.dasa_api.controllers.UserController;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserControllerIntegrationTest {

    @Autowired
    private UserController userController;

    @Test
    public void testGetAllUsers_withRealDatabase() {
        ResponseEntity<ApiListResponse<ResponseUserDTO>> response = userController.getAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        List<ResponseUserDTO> users = response.getBody().getData();
        assertNotNull(users);
        assertFalse(users.isEmpty(), "A lista de usuários deve conter pelo menos um item");

        ResponseUserDTO first = users.get(0);
        assertNotNull(first.getId());
        assertNotNull(first.getName());
    }
}

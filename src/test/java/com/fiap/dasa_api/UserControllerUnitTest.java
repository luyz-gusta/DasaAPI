package com.fiap.dasa_api;


import com.fiap.dasa_api.controllers.UserController;
import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.infra.responses.details.ApiListResponse;
import com.fiap.dasa_api.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerUnitTest {

    @Test
    public void testGetAllUsers() {
        // Arrange
        UserService mockService = Mockito.mock(UserService.class);
        UserController controller = new UserController(mockService);

        ResponseUserDTO mockUser = new ResponseUserDTO();
        mockUser.setId(1L);
        mockUser.setName("João");

        when(mockService.listAllUsers()).thenReturn(List.of(mockUser));

        // Act
        ResponseEntity<ApiListResponse<ResponseUserDTO>> response = controller.getAllUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("João", response.getBody().getData().get(0).getName());

        verify(mockService, times(1)).listAllUsers();
    }
}

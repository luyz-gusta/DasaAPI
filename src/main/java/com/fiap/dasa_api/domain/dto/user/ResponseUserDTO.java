package com.fiap.dasa_api.domain.dto.user;

import com.fiap.dasa_api.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUserDTO {
    private Long id;
    private String name;
    private Date dateBirth;
    private String registration;
    private String email;
    private String photo;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


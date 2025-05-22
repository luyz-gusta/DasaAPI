package com.fiap.dasa_api.domain.dto.user;


import com.fiap.dasa_api.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ResponseUserDTO {
    private Long id;
    private String name;
    private Date date_birth;
    private String registration;
    private String email;
    private String photo;
    private Boolean status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ResponseUserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.date_birth = user.getDate_birth();
        this.photo = user.getPhoto();
        this.registration = user.getRegistration();
        this.status = user.getStatus();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }
}

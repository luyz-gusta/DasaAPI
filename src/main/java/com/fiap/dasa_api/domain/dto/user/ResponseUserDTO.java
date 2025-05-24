package com.fiap.dasa_api.domain.dto.user;

import java.time.LocalDateTime;
import java.util.Date;

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
}


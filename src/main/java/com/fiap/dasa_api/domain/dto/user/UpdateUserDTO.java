package com.fiap.dasa_api.domain.dto.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class UpdateUserDTO {
    @NotNull
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull
    private String name;

    @NotNull
    @Past
    private Date date_birth;

    @Nullable
    private String registration;

    @NotBlank(message = "email is required")
    @NotNull
    private String email;

    @Nullable
    private String photo;

    @Nullable
    private String reset_token;

    @Nullable
    private LocalDateTime valided_token;
}

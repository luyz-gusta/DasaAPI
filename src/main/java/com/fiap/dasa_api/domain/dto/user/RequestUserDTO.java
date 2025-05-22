package com.fiap.dasa_api.domain.dto.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RequestUserDTO {

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

    @NotBlank(message = "password is required")
    @NotNull
    private String password;

    @Nullable
    private String photo;
}

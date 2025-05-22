package com.fiap.dasa_api.domain.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
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
    @Schema(example = "Gustavo", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotNull
    @Past
    @Schema(example = "2006-02-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private Date date_birth;

    @Nullable
    private String registration;

    @NotBlank(message = "email is required")
    @NotNull
    @Email(message = "must be a well-formed email address")
    @Schema(example = "gustavo@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "password is required")
    @NotNull
    private String password;

    @Nullable
    private String photo;
}

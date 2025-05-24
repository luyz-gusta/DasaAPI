package com.fiap.dasa_api.domain.dto.typeMaterial;

import com.fiap.dasa_api.domain.entities.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class RequestTypeMaterialDTO {

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Medicamento", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;
}

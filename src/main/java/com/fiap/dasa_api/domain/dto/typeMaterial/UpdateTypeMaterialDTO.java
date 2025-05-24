package com.fiap.dasa_api.domain.dto.typeMaterial;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTypeMaterialDTO {
    @NotNull
    private Long id;

    @Nullable
    private Boolean status;

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Medicamento", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;
}

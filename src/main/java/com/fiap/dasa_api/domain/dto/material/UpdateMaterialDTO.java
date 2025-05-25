package com.fiap.dasa_api.domain.dto.material;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateMaterialDTO {
    @NotNull
    private Long id;

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Paracetamol", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Nullable
    private Boolean status;

    @NotBlank(message = "Name is required")
    @NotNull
    @Schema(example = "Paracetamol", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantity;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idTypeMaterial;
}

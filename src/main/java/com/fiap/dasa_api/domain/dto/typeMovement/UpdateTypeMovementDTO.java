package com.fiap.dasa_api.domain.dto.typeMovement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTypeMovementDTO {
    @NotNull
    private Long id;

    @Nullable
    private Boolean status;

    @NotBlank(message = "Movement is required")
    @NotNull
    @Schema(example = "Medicamento", requiredMode = Schema.RequiredMode.REQUIRED)
    private String Movement;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;
}

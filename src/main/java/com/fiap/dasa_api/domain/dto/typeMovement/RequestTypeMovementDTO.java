package com.fiap.dasa_api.domain.dto.typeMovement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestTypeMovementDTO {

    @NotBlank(message = "Movement is required")
    @NotNull
    @Schema(example = "Medicamento", requiredMode = Schema.RequiredMode.REQUIRED)
    private String movement;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;
}

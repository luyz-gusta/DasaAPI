package com.fiap.dasa_api.domain.dto.stock;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateStockDTO {
    @NotNull
    private Long id;

    @NotBlank(message = "Quantity is required")
    @NotNull
    @Schema(example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantity;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idTypeMovement;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idBarcode;
}

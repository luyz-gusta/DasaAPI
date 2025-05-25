package com.fiap.dasa_api.domain.dto.barcode;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBarcodeDTO {
    @NotNull
    private Long id;

    @NotBlank(message = "Barcode is required")
    @NotNull
    @Schema(example = "A83C732HW", requiredMode = Schema.RequiredMode.REQUIRED)
    private String barcode;

    @Nullable
    private Boolean status;

    @NotBlank(message = "Quantity is required")
    @NotNull
    @Schema(example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
    private int quantity;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idUser;

    @NotNull
    @Schema(example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long idMaterial;
}

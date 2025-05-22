package com.fiap.dasa_api.infra.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ExceptionDTO {
    private Integer status;
    private String message;
}

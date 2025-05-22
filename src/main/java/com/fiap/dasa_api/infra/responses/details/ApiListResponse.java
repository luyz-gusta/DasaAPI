package com.fiap.dasa_api.infra.responses.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ApiListResponse<T> {
    private Integer status;
    private String message;
    private List<T> data;
}

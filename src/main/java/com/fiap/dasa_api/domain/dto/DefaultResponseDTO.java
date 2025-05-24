package com.fiap.dasa_api.domain.dto;

import java.time.LocalDateTime;

public interface DefaultResponseDTO {
    Long getId();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}

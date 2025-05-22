package com.fiap.dasa_api.infra.errors.exceptions;

import com.fiap.dasa_api.infra.errors.ExceptionDTO;
import com.fiap.dasa_api.infra.responses.details.ApiMessageResponse;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> entityNotFoundExceptionHandler(){
        ExceptionDTO response = new ExceptionDTO(404, "Registro não encontrado!");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<ExceptionDTO> internalServerErrorExceptionHandler(Exception exp){
        ExceptionDTO response = new ExceptionDTO(500, exp.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ExceptionDTO> duplicateKeyExceptionHandler(String key){
        ExceptionDTO response = new ExceptionDTO(400, "Duplicidade nos dados, já existe um registro com esse " + key);

        return ResponseEntity.badRequest().body(response);
    }
}

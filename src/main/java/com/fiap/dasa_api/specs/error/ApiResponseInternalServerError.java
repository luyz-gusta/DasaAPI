package com.fiap.dasa_api.specs.error;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@ApiResponse(
        responseCode = "500",
        description = "${springdoc.swagger-config.responses.error.500}",
        content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = @ExampleObject(
//                        name = "A general error occurred while processing the request",
                        summary = "Unexpected internal error",
                        value = "{ \"status\": \"500\", \"message\": \"Error interno no servidor!\" }"
                )
        )
)
public @interface ApiResponseInternalServerError {
}

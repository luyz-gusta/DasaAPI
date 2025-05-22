//package br.senai.sp.menu.restaurante.rest.specs.commons.response.error;
//
//import br.senai.sp.menu.restaurante.errors.ErrorResponse;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import org.springframework.http.MediaType;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
////@ApiResponse(
////        responseCode = "401",
////        description = "${springdoc.swagger-config.responses.error.401}",
////        content = @Content(
////                mediaType = MediaType.APPLICATION_JSON_VALUE,
////                schema = @Schema(
////                        implementation = ErrorResponse.class,
////                        example = "{ \"error\": \"BAD_CREDENTIALS\", \"details\": null }"
////                )
////        )
////)
//
//@ApiResponse(
//        responseCode = "401",
//        description = "${springdoc.swagger-config.responses.error.401}",
//        content = @Content(
//                mediaType = MediaType.APPLICATION_JSON_VALUE,
//                examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
//                        name = "Invalid credentials",
//                        summary = "JWT token is missing or incorrect",
//                        value = "{ \"error\": \"BAD_CREDENTIALS\", \"details\": {} }"
//                ),
//                schema = @Schema(implementation = ErrorResponse.class)
//        )
//)
//
//
//public @interface ApiResponseUnauthorized {
//}
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
        responseCode = "401",
        description = "${springdoc.swagger-config.responses.error.401}",
        content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                examples = @ExampleObject(
                        //summary = "Invalid credentials",
                        value = "{ \"error\": \"BAD_CREDENTIALS\", \"details\": {} }"
                )
        )
)

public @interface ApiResponseUnauthorized {
}

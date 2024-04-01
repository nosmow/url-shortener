package com.dainercortes.urlshortener.infra.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity dealError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity dealError400() {
        return ResponseEntity.badRequest().body("Verify that you are not sending empty data");
    }

    @ExceptionHandler(IntegrityValidation.class)
    public ResponseEntity errorHandlerIntegrityValidation(IntegrityValidation e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

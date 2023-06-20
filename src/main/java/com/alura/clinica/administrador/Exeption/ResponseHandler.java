package com.alura.clinica.administrador.Exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

/*
 * When the server launch an type exception, this class catch the exception
 * and response with custom response status code.
 */
@RestControllerAdvice
public class ResponseHandler {

    /*
     * If sql not found an entity the server response 404.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<?> error404Handler() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> Error400Handler(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(DataErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    /* this record permit send body with message custom of the error */
    private record DataErrorValidation(String field, String error) {
        /* constructor */
        DataErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

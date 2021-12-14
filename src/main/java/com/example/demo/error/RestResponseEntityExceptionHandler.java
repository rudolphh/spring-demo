package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// a global @ExceptionHandler
@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { DuplicateEmailException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        throw new ResponseStatusException(
                HttpStatus.CONFLICT, ex.getMessage(), ex
        );
    }

    @ExceptionHandler(value
            = { StudentNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {

        String bodyOfResponse = ex.getMessage();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.getMessage(), ex
        );
    }
}

package com.example.demo.error;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// a global @ExceptionHandler
//@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value
//            = { IllegalArgumentException.class, IllegalStateException.class })
//    protected ResponseEntity<Object> handleConflict(
//            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = ex.getMessage();
//        return handleExceptionInternal(ex, bodyOfResponse,
//                new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
}

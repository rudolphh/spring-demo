package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND
)
public class StudentNotFoundException
        extends RuntimeException {

    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

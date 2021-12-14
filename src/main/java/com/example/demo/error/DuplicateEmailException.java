package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.CONFLICT,
        reason = "Email already exists"
)
public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String errorMessage){
        super(errorMessage);
    }
}

package org.example.userauthservice.controllers;

import org.example.userauthservice.exceptions.PasswordMismatchException;
import org.example.userauthservice.exceptions.UserAlreadyExistsException;
import org.example.userauthservice.exceptions.UserNotSignedUpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler({UserAlreadyExistsException.class, UserNotSignedUpException.class, PasswordMismatchException.class})
    public ResponseEntity<String> handleSignupExceptions(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

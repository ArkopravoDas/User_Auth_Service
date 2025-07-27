package org.example.userauthservice.exceptions;

public class UserNotSignedUpException extends RuntimeException {
    public UserNotSignedUpException(String message) {
        super(message);
    }
}

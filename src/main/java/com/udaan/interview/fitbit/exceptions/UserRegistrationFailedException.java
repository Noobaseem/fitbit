package com.udaan.interview.fitbit.exceptions;

public class UserRegistrationFailedException extends RuntimeException {

    public UserRegistrationFailedException(String message) {
        super(message);
    }
}

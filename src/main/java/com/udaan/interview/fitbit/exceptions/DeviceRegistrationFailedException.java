package com.udaan.interview.fitbit.exceptions;

public class DeviceRegistrationFailedException extends RuntimeException {

    public DeviceRegistrationFailedException(String message) {
        super(message);
    }
}

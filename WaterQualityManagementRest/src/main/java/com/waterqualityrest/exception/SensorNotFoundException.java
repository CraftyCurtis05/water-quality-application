package com.waterqualityrest.exception;

public class SensorNotFoundException extends RuntimeException {

    public SensorNotFoundException(String message) {

        super(message);
    }
}
package com.waterquality.waterqualitymanagementrest.exception;

public class SensorDataNotFoundException extends  RuntimeException {

    public SensorDataNotFoundException(String message)
    {
        super(message);
    }
}
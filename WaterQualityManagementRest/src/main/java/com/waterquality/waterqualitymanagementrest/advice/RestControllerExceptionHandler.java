package com.waterquality.waterqualitymanagementrest.advice;

import com.waterquality.waterqualitymanagementrest.dto.ErrorMessage;
import com.waterquality.waterqualitymanagementrest.exception.SensorBadRequestException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    //400 BAD REQUEST (CLIENT REQUEST NOT UNDERSTOOD BC OF BAD SYNTAX; REQUEST MODIFICATION REQUIRED)
    @ExceptionHandler(SensorBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage sensorBadRequestException(SensorBadRequestException sensorBadRequestException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(), sensorBadRequestException.getMessage());

        return errorMessage;
    }

    //404 NOT FOUND (SERVER CAN NOT FIND REQUESTED RESOURCE)
    @ExceptionHandler(SensorNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage sensorNotFoundException(SensorNotFoundException sensorNotFoundException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), sensorNotFoundException.getMessage());

        return errorMessage;
    }
}
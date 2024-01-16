package com.waterquality.waterqualitymanagementrest.advice;

import com.waterquality.waterqualitymanagementrest.dto.ErrorMessage;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataInvalidException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    //404 NOT FOUND (GET/DELETE - SERVER CAN NOT FIND REQUESTED RESOURCE)
    @ExceptionHandler(SensorNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage sensorNotFoundException(SensorNotFoundException sensorNotFoundException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), sensorNotFoundException.getMessage());

        return errorMessage;
    }

    //422 UNPROCESSABLE ENTITY (POST/PUT - ISSUE WITH REQUEST PAYLOAD; ENSURE FORMATTED CORRECTLY AND VALID)
    @ExceptionHandler(SensorDataInvalidException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage sensorDataInvalidException(SensorDataInvalidException sensorDataInvalidException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), sensorDataInvalidException.getMessage());

        return errorMessage;
    }
}
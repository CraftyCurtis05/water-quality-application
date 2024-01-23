package com.waterquality.waterqualitymanagementrest.advice;

import com.waterquality.waterqualitymanagementrest.dto.ErrorMessage;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataInvalidException;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataNotFoundException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    //404 NOT FOUND - SENSOR (GET/DELETE - SERVER CAN NOT FIND REQUESTED RESOURCE)
    @ExceptionHandler(SensorNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage sensorNotFoundException(SensorNotFoundException sensorNotFoundException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), sensorNotFoundException.getMessage());

        return errorMessage;
    }

    //404 NOT FOUND - SENSOR DATA (GET/DELETE - SERVER CAN NOT FIND REQUESTED RESOURCE)
    @ExceptionHandler(SensorDataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage sensorDataNotFoundException(SensorDataNotFoundException sensorDataNotFoundException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(),sensorDataNotFoundException.getMessage());

        return errorMessage;
    }

    //SPRING BOOT MethodArgumentNotValidException WITH @VALID
    //Invalid Request Payload: This is the most common cause. For instance, when a client sends data that doesn't meet the validation criteria defined in the DTO (Data Transfer Object).
    //Binding Errors: When the expected format of an incoming request body doesn't match the expected format.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ErrorMessage sensorDataInvalidException(SensorDataInvalidException sensorDataInvalidException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.ACCEPTED.value(), new Date(),sensorDataInvalidException.getMessage());

        return errorMessage;
    }
}
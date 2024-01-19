package com.waterquality.waterqualitymanagementrest.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private int statusCode;

    private Date timestamp;

    private String message;
}
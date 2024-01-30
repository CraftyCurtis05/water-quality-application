package com.waterquality.waterqualitymanagementrest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SensorDataDto {

    private long dataId;

    private long sensorId;

    private long parameterId;

    @NotBlank(message = "Year Should NOT Be Blank!")
    @Size(max = 4)
    private String year;

    @NotBlank(message = "Month Should NOT Be Blank!")
    @Size(max = 2)
    private String month;

    @NotBlank(message = "Parameter Value Should NOT Be Blank!")
    private double parameterValue;
}
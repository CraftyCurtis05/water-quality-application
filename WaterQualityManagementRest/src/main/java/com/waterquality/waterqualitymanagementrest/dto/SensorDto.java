package com.waterquality.waterqualitymanagementrest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private long sensorId;

    @NotBlank(message = "Name Should NOT Be Blank!")
    private String sensorName;

    @NotNull(message = "Should Be TRUE If Active OR FALSE If Not Active!")
    private boolean isActive;

    @NotBlank(message = "Description Should NOT Be Blank!")
    private String sensorDescription;
}
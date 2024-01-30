package com.waterquality.waterqualitymanagementrest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private long sensorId;

    @NotBlank(message = "Name Should NOT Be Blank!")
    @Size(max = 5)
    private String sensorName;

    @NotNull(message = "Should Be TRUE If Active OR FALSE If Not Active!")
    private boolean active;

    @NotBlank(message = "Description Should NOT Be Blank!")
    private String sensorDescription;
}
package com.waterqualityrest.dto;

import lombok.*;
import com.waterqualityrest.entity.Parameter;
import com.waterqualityrest.entity.Sensor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SensorDataDto {

    private long id;

    private Sensor sensor;

    private String year;

    private String month;

    private Parameter parameter;

    private double parameterValue;
}
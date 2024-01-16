package com.waterquality.waterqualitymanagementrest.dto;

import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.entity.Parameter;
import lombok.*;

@Data
@AllArgsConstructor
public class SensorDataDto {

    private long id;

    private SensorDto sensor;

    private ParameterDto parameter;

    private String year;

    private String month;

    private double parameterValue;
}
package com.waterqualityconsumer.waterqualitymanagementrestclient.dto;

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

    private String year;

    private String month;

    private double parameterValue;
}
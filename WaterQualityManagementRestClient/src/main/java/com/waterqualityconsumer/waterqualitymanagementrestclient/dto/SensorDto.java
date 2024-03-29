package com.waterqualityconsumer.waterqualitymanagementrestclient.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private long sensorId;

    private String sensorName;

    private boolean isActive;

    private String sensorDescription;
}
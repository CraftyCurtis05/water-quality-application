package com.waterquality.waterqualitymanagementrest.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {

    private long id;

    private Sensor sensor;

    private Parameter parameter;

    private String year;

    private String month;

    private double parameterValue;

    public boolean calculateIfTheParameterDrinkable() {
        return true;
    }
}
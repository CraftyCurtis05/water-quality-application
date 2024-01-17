package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="wq_sensor_data_develop")
@Data
@Getter
@Setter
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Sensor sensor;

    private Parameter parameter;

    private String year;

    private String month;

    private double parameterValue;

    public boolean calculateIfTheParameterDrinkable() {
        return true;
    }
}
package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="wq_sensor_data")
@Data
@Getter
@Setter
@NoArgsConstructor
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dataId;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "parameter_id", nullable = false)
    private Parameter parameter;

    private String year;

    private String month;

    private double parameterValue;
}
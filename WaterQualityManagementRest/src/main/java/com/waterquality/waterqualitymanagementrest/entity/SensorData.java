package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="wq_sensor_data") //Table Name
@Data
@Getter
@Setter
@NoArgsConstructor
public class SensorData {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO, IDENTITY, SEQUENCE, TABLE, TEMPORAL(date, time, etc)
    private long dataId;

    @ManyToOne //Foreign Key
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @ManyToOne //Foreign Key
    @JoinColumn(name = "parameter_id", nullable = false)
    private Parameter parameter;

    @Column(name = "year", nullable = false, length = 4)
    private String year;

    @Column(name = "month", nullable = false, length = 2)
    private String month;

    @Column(name = "parameter_value", nullable = false)
    private double parameterValue;
}
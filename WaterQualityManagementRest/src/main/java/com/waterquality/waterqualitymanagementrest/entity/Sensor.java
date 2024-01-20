package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="wq_sensor") //Table Name
@Data
@Getter
@Setter
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO, IDENTITY, SEQUENCE, TABLE, TEMPORAL(date, time, etc)
    @Column(name = "sensor_id", nullable = false)
    private Long sensorId;

    @Column(name = "sensor_name", nullable = false, length = 20)
    private String sensorName;

    @Column(name = "is_active", nullable = false, length = 5)
    private boolean isActive;

    @Column(name = "location_description", nullable = false, length = 30)
    private String sensorDescription; //Location
}
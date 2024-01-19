package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="wq_sensor") //Table Name
@Data
@Getter
@Setter
@NoArgsConstructor
public class Sensor {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO, IDENTITY, SEQUENCE, TABLE, TEMPORAL(date, time, etc)
    private long sensorId;

    @Column(name = "sensor_name", nullable = false, length = 20)
    private String sensorName;

    @Column(name = "is_active", nullable = false, length = 5)
    private boolean isActive;

    @Column(name = "description", nullable = false, length = 30)
    private String sensorDescription; //Location
}
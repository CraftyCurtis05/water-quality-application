package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="wq_sensor_develop") //table name
@Data
@Getter
@Setter
@NoArgsConstructor
public class Sensor {

    @Id //primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY) //AUTO, IDENTITY, SEQUENCE, TABLE, TEMPORAL(date, time, etc)
    private long id;

    @Column(name = "sensor_name", nullable=false, length=20)
    private String name;

    private boolean active;

    private String description; //location
}
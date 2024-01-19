package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="wq_parameter") //Table Name
@Data
@Getter
@Setter
@NoArgsConstructor
public class Parameter {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO, IDENTITY, SEQUENCE, TABLE, TEMPORAL(date, time, etc)
    private long parameterId;

    @Column(name = "parameter_name", nullable = false)
    private String parameterName;
}
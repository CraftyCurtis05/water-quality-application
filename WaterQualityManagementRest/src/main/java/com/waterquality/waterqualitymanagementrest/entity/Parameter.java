package com.waterquality.waterqualitymanagementrest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="wq_parameter")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parameterId;

    private String parameterName;
}
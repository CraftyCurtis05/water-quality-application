package com.waterqualityrest.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    private long id;

    private String name;

    private boolean active;

    private String description;
}
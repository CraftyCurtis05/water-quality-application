package com.waterqualityrest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private long id;

    private String name;

    private boolean active;

    private String description;
}
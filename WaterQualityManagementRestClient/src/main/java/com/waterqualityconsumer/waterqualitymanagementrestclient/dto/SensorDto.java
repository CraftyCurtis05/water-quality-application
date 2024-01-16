package com.waterqualityconsumer.waterqualitymanagementrestclient.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private long id;

    private String name;

    private boolean active;

    private String description;

}
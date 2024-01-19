package com.waterquality.waterqualitymanagementrest.mapper;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.entity.Sensor;

public class SensorMapper {

    public static SensorDto toDTO(Sensor sensor) {
        SensorDto dto = new SensorDto();
        dto.setSensorId(sensor.getSensorId());
        dto.setSensorName(sensor.getSensorName());
        dto.setActive(sensor.isActive());
        dto.setSensorDescription(sensor.getSensorDescription());
        return dto;
    }

    public static Sensor toEntity(SensorDto dto) {
        Sensor sensor = new Sensor();
        sensor.setSensorId(dto.getSensorId());
        sensor.setSensorName(dto.getSensorName());
        sensor.setActive(dto.isActive());
        sensor.setSensorDescription(dto.getSensorDescription());
        return sensor;
    }
}
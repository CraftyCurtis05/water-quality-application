package com.waterquality.waterqualitymanagementrest.mapper;

import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.entity.Parameter;
import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.entity.SensorData;

public class SensorDataMapper {

    public static SensorDataDto toDTO(SensorData sensorData) {
        SensorDataDto dto = new SensorDataDto();
        dto.setSensorId(sensorData.getDataId());
        dto.setSensorId(sensorData.getSensor().getSensorId());
        dto.setParameterId(sensorData.getParameter().getParameterId());
        dto.setYear(sensorData.getYear());
        dto.setMonth(sensorData.getMonth());
        dto.setParameterValue(sensorData.getParameterValue());
        return dto;
    }

    public static SensorData toEntity(SensorDataDto dto, Sensor sensor, Parameter parameter) {
        SensorData sensorData = new SensorData();
        sensorData.setDataId(dto.getDataId());
        sensorData.setSensor(sensor);
        sensorData.setParameter(parameter);
        sensorData.setYear(dto.getYear());
        sensorData.setMonth(dto.getMonth());
        sensorData.setParameterValue(dto.getParameterValue());
        return sensorData;
    }
}
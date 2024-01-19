package com.waterquality.waterqualitymanagementrest.mapper;

import com.waterquality.waterqualitymanagementrest.dto.ParameterDto;
import com.waterquality.waterqualitymanagementrest.entity.Parameter;

public class ParameterMapper {

    public static ParameterDto toDTO(Parameter parameter) {
        ParameterDto dto = new ParameterDto();
        dto.setParameterId(parameter.getParameterId());
        dto.setParameterName(parameter.getParameterName());
        return dto;
    }

    public static Parameter toEntity(ParameterDto dto) {
        Parameter parameter = new Parameter();
        parameter.setParameterId(dto.getParameterId());
        parameter.setParameterName(dto.getParameterName());
        return parameter;
    }
}
package com.waterquality.waterqualitymanagementrest.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ReportDto {

    private String sensorName;

    private String yearMonth;

    private String result;
}
package com.waterquality.waterqualitymanagementrest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private String sensorName;

    private String yearMonth;

    private String year;

    private String result;
}
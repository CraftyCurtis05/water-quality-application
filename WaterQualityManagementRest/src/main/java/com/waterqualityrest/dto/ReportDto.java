package com.waterqualityrest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private String sensorName;

    private String year;

    private String month;

    private String result;
}
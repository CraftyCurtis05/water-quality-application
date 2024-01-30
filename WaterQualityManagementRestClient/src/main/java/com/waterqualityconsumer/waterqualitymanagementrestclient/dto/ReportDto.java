package com.waterqualityconsumer.waterqualitymanagementrestclient.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private String sensorName;

    private String month;

    private String year;

    private String result;
}
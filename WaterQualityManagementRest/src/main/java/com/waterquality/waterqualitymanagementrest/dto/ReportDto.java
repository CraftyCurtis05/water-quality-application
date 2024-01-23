package com.waterquality.waterqualitymanagementrest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    @NotBlank(message = "Name Should NOT Be Blank!")
    private String sensorName;

    @NotBlank(message = "Year And Month Should NOT Be Blank!")
    private String yearMonth;

    @NotBlank(message = "Year Should NOT Be Blank!")
    private String year;

    @NotBlank(message = "Result Should NOT Be Blank!")
    private String result;
}
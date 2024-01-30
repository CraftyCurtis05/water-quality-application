package com.waterquality.waterqualitymanagementrest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 4)
    private String year;

    @NotBlank(message = "Month Should NOT Be Blank!")
    @Size(max = 2)
    private String month;

    @NotBlank(message = "Result Should NOT Be Blank!")
    private String result;
}
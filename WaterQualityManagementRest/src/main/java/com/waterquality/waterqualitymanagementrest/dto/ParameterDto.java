package com.waterquality.waterqualitymanagementrest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDto {

    private long parameterId;

    @NotBlank(message = "Name Should NOT Be Blank!")
    private String parameterName;
}
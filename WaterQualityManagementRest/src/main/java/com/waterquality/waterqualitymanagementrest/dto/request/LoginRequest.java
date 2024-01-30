package com.waterquality.waterqualitymanagementrest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest
{
    @NotBlank (message = "Username Should NOT Be Blank!")
    private String username;

    @NotBlank (message = "Password Should NOT Be Blank!")
    private String password;
}
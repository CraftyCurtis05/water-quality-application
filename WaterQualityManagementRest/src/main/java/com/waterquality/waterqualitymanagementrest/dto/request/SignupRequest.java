package com.waterquality.waterqualitymanagementrest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @NotBlank (message = "Username Should NOT Be Blank!")
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank (message = "Email Should NOT Be Blank!")
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank (message = "Password Should NOT Be Blank!")
    @Size(min = 6, max = 40)
    private String password;
}
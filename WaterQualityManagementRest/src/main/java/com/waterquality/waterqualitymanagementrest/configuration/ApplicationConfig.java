package com.waterquality.waterqualitymanagementrest.configuration;

import com.waterquality.waterqualitymanagementrest.util.ApplicationUtilities;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApplicationUtilities applicationUtilities() {
        return new ApplicationUtilities();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Value("${REMOTE_BASE_URI}")
    String baseURI;
}
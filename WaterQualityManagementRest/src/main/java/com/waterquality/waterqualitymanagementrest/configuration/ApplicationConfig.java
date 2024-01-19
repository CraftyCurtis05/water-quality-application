package com.waterquality.waterqualitymanagementrest.configuration;

import com.waterquality.waterqualitymanagementrest.util.ApplicationUtilities;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApplicationUtilities applicationUtilities() {
        return new ApplicationUtilities();
    }

    @Value("${REMOTE_BASE_URI}")
    String baseURI;
}
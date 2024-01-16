package com.waterqualityrest.configuration;

import com.waterqualityrest.util.ApplicationUtilities;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApplicationUtilities applicationUtilities() {
        return new ApplicationUtilities();
    }

    @Value("${REMOTE_BASE_URI}")
    String baseURI;

    @Bean
    RestClient restClient() {
        return RestClient.create(baseURI);
    }
}
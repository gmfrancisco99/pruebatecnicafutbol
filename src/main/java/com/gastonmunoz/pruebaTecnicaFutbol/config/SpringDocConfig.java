package com.gastonmunoz.pruebaTecnicaFutbol.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("API Fútbol")
                .pathsToMatch("/auth/**", "/equipos/**")
                .build();
    }
}

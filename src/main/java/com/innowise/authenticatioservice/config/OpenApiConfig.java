package com.innowise.authenticatioservice.config;

import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() throws IOException {
        Resource resource = new ClassPathResource("static/openapi/openapi.yaml");
        String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        return new OpenAPIV3Parser().readContents(content).getOpenAPI();
    }
}
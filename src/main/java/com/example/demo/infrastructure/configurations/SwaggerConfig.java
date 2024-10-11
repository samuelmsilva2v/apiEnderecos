package com.example.demo.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI customOpenApi() {
		
		OpenAPI openAPI = new OpenAPI()
		.components(new Components())
		.info(new Info()
		.title("API Endereços")
		.description("CRUD de Endereços")
		.version("v1")
		);
		
		return openAPI;
	}
}

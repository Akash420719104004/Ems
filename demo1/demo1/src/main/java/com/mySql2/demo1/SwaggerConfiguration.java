package com.mySql2.demo1;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI api() {
        return new OpenAPI();
    }
}

package com.yourteam.cricketfantasy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cricketFantasyAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cricket Fantasy API")
                        .description("API documentation for Cricket Fantasy application")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Your Team")
                                .email("support@yourteam.com")
                                .url("https://yourteam.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
} 
package com.user_service_webclient_consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder, @Value("${apiUrl}") String baseUrl) {
        return builder.baseUrl(baseUrl).build();
    }
}

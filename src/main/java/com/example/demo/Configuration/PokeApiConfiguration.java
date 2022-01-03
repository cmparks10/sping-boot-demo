package com.example.demo.Configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PokeApiConfiguration {
    public static final String POKE_API_REST_TEMPLATE_BEAN = "pokeApiRestTemplate";
    @Bean(POKE_API_REST_TEMPLATE_BEAN )
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.defaultHeader(HttpHeaders.USER_AGENT, "Application")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.getType())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.getType())
                .build();
    }
}

package com.example.demo.Controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(value = "/pokemonNotWorking")
    public static void pokemonNotWorking(@RequestHeader(value="User-Agent") String userAgent) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String uri = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
            String result = restTemplate.getForObject(uri, String.class);
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    };

    @GetMapping(value = "/pokemon")
    public static ResponseEntity<String> Pokemon() {
        ResponseEntity<String> responseJson = null;
        try {
            final String resourceUrl = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = setHeaders();
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseJson;
    };

    public static HttpEntity<String> setHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;

    }

}
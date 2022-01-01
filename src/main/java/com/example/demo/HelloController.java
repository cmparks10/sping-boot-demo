package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdk.nashorn.internal.objects.NativeJSON;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Exchanger;

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

            HttpEntity<String> entity = new HttpEntity<>(headers);
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseJson;
    };

    public void setHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

    }

}
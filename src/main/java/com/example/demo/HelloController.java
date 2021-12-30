package com.example.demo;

import jdk.nashorn.internal.objects.NativeJSON;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/fart")
    public String secondIndex() {
        return "This smells like fart!";
    }

    @GetMapping("/pokemon")
    public void pokeIndex() {
        final String uri = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
        JSONObject json = new JSONObject();

        System.out.println("1");
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("2");
        JSONObject result = restTemplate.getForObject(uri, JSONObject.class);
        System.out.println("3");
        System.out.println(result.toString());

    }

}
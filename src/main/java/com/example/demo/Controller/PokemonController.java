package com.example.demo.Controller;

import com.example.demo.Configuration.PokeApiConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PokemonController {
    private RestTemplate restTemplate;
    public PokemonController(@Qualifier(PokeApiConfiguration.POKE_API_REST_TEMPLATE_BEAN) RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // your getFromUrl method
    @GetMapping(value = "/pokemonBean")
    public static String Pokemon() {
        String responseJson = null;
        try {
            final String resourceUrl = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
            RestTemplate restTemplate = new RestTemplate();
            responseJson = restTemplate.getForObject(resourceUrl, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseJson;
    };







}

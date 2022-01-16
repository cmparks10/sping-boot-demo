package com.example.demo.Controller;

import com.example.demo.Configuration.PokeApiConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PokemonController {
    private RestTemplate restTemplate;

    @GetMapping(value = "/pokemonBean")
    public String PokemonController(@Qualifier(PokeApiConfiguration.POKE_API_REST_TEMPLATE_BEAN) RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        String responseJson = null;
        try {
            final String resourceUrl = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
            responseJson = restTemplate.getForObject(resourceUrl, String.class);
            //responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, restTemplate.headForHeaders(), String.class);
            //responseJson = restTemplate.exchange(resourceUrl, String.Ob);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            return responseJson;
        };

}


package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdk.nashorn.internal.objects.NativeJSON;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
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
import java.util.Collections;
import java.util.concurrent.Exchanger;

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

    @GetMapping("/testURL")
    public void testURL() throws IOException {
        final String uri = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
        URL url = new URL("http://localhost:8080/foobar");
        URLConnection hc = url.openConnection();
        hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

        System.out.println("Here is the connection: "+hc.getContentType());
        //returns text/html;charset=UTF-8
    }

    @GetMapping("/pokemon")
    public JSONObject pokeIndex() throws IOException {
        //final String uri = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
        final String uri = "https://gorest.co.in/public/v1/users";

        //JSONObject json = new JSONObject();
        //System.out.println("1");
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("here");
        JSONObject result = restTemplate.getForObject(uri, JSONObject.class);
        //String resultt = restTemplate.getForObject(uri, String.class);
        System.out.println("3");
        System.out.println(result);
        return result;
    }


    @GetMapping("/GoRestApiV1Users")
    public String getFromUrl2() throws JsonProcessingException {
        final String uri = "https://gorest.co.in/public/v1/users";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }


}
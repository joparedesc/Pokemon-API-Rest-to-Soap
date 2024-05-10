package com.app.soap.ApiRestToSoapPokemon.clientRest.service;


import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service("pokeApiRestTemplateService")
public class PokeApiRestTemplateServiceImpl implements PokeApiService{

    @Autowired
    private RestTemplate clientRestTemplate;

    /*
    @Override
    public PokeApiResponse getPokemon(String name) {

        Map<String,String> pathVariables=new HashMap<String,String >();
        pathVariables.put("name",name);

        PokeApiResponse pokeApiResponse=clientRestTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/{name}",PokeApiResponse.class,pathVariables);
        return pokeApiResponse;
    }*/

    @Override
    public PokeApiResponse getPokemon(String name) {

        Map<String,String> pathVariables=new HashMap<String,String >();
        pathVariables.put("name",name);

        PokeApiResponse pokeApiResponse=clientRestTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/{name}",PokeApiResponse.class,pathVariables);
        return pokeApiResponse;
    }

}

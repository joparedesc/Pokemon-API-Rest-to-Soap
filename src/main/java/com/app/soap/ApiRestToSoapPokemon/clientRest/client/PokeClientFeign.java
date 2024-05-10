package com.app.soap.ApiRestToSoapPokemon.clientRest.client;

import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemon",url = "https://pokeapi.co/api/v2")
public interface PokeClientFeign {

    @GetMapping("/pokemon/{name}")
    public PokeApiResponse getPokemon(@PathVariable String name);
}

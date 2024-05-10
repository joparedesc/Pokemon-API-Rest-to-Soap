package com.app.soap.ApiRestToSoapPokemon.clientRest.controller;


import com.app.soap.ApiRestToSoapPokemon.clientRest.client.PokeHttpClient;
import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import com.app.soap.ApiRestToSoapPokemon.clientRest.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("${controller.base-path}")
public class ControllerPokeApi {

    @Autowired
    @Qualifier("pokeApiFeignService")
    private PokeApiService pokeApiService;

    @Autowired
    private PokeHttpClient pokeHttpClient;

    @GetMapping(
            path = "${controller.api-get-pokemon-by-name}"
    )
    public PokeApiResponse getPokemon(@PathVariable String name) throws Exception {
        return pokeHttpClient.getPokemon(name);
    }
}

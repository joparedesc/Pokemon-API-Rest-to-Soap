package com.app.soap.ApiRestToSoapPokemon.clientRest.service;

import com.app.soap.ApiRestToSoapPokemon.clientRest.client.PokeClientFeign;
import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("pokeApiFeignService")
public class PokeApiFeignServiceImpl implements PokeApiService{

    @Autowired
    private PokeClientFeign pokeClientFeign;

    @Override
    public PokeApiResponse getPokemon(String name) {
        return pokeClientFeign.getPokemon(name);
    }
}

package com.app.soap.ApiRestToSoapPokemon.clientRest.service;

import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;

public interface PokeApiService {

    public PokeApiResponse getPokemon(String name);
}

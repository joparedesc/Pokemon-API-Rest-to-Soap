package com.app.soap.ApiRestToSoapPokemon.bd.service;


import com.app.soap.ApiRestToSoapPokemon.bd.entity.PokeApi;
import com.app.soap.ApiRestToSoapPokemon.bd.repository.PokeApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * PokeApiService class.
 * Class service of PokeApi
 */
public class PokeApiService {

    @Autowired
    /** PokeApiRepository repository property */
    private PokeApiRepository pokeApiRepository;

    /**
     * getList method.
     * @return List<PokeApi>
     */
    public List<PokeApi> getList(){

        return pokeApiRepository.findAll();

    }

    /**
     * savePokeApiRequest method.
     * @param pokeApi
     * @return PokeApi
     */
    public PokeApi savePokeApiRequest(PokeApi pokeApi){

        return pokeApiRepository.save(pokeApi);

    }

}

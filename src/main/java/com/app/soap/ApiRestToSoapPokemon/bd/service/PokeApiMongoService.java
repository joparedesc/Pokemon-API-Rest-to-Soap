package com.app.soap.ApiRestToSoapPokemon.bd.service;


import com.app.soap.ApiRestToSoapPokemon.bd.entity.PokeApiMongo;
import com.app.soap.ApiRestToSoapPokemon.bd.repository.PokeApiMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
/**
 * PokeApiMongoService class.
 * Class service of PokeApiMongo.
 */
public class PokeApiMongoService {

    @Autowired
    /** PokeApiMongoRepository repository property */
    private PokeApiMongoRepository pokeApiMongoRepository;

    /**
     * autoIncrementId method.
     * Method to auto increment id.
     * @return int id.
     */
    private int autoIncrementId(){
        List<PokeApiMongo> pokeApiMongoList=pokeApiMongoRepository.findAll();

        return pokeApiMongoList.isEmpty()?1: (pokeApiMongoList.stream()
                .max(Comparator.comparing(PokeApiMongo::getId))
                .get().getId() + 1);
    }

    /**
     * savePokeApiMongo method.
     * Method to save pokemon into MongoDB.
     * @param pokeApiMongo
     * @return PokeApiMongo
     */
    public PokeApiMongo savePokeApiMongo(PokeApiMongo pokeApiMongo){
        int id=autoIncrementId();
        PokeApiMongo pokeApiMongo1=new PokeApiMongo(id,pokeApiMongo.getIpOrigin(),pokeApiMongo.getRequestDate(),pokeApiMongo.getMethod());
        return pokeApiMongoRepository.save(pokeApiMongo1);
    }
}

package com.app.soap.ApiRestToSoapPokemon.bd.repository;


import com.app.soap.ApiRestToSoapPokemon.bd.entity.PokeApiMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * PokeApiMongoRepository interface.
 * Interface PokeApiMongoRepository of JPA repository.
 * @autor jjpc
 */
public interface PokeApiMongoRepository extends MongoRepository<PokeApiMongo,Integer> {
}

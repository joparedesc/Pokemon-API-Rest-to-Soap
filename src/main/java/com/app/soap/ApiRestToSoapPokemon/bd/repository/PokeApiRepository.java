package com.app.soap.ApiRestToSoapPokemon.bd.repository;

import com.app.soap.ApiRestToSoapPokemon.bd.entity.PokeApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * PokeApiRepository interface.
 * Interface PokeApiRepository of JPA repository.
 * @autor jjpc
 */
public interface PokeApiRepository extends JpaRepository <PokeApi,Integer> {

}

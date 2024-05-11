package com.app.soap.ApiRestToSoapPokemon.webService.endpoint;


import com.app.soap.ApiRestToSoapPokemon.GetPokemonRequest;
import com.app.soap.ApiRestToSoapPokemon.GetPokemonResponse;
import com.app.soap.ApiRestToSoapPokemon.Pokemon;
import com.app.soap.ApiRestToSoapPokemon.clientRest.client.PokeApiHttpClient;
import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.app.soap.ApiRestToSoapPokemon.*;

import java.math.BigInteger;


@Endpoint
public class PokeAPIEndPoint {

    private static final String NAMESPACE_URI = "http://joparedescano.org/pokeapi";

    private PokeApiResponse getPokemon(String name){

        PokeApiHttpClient pokeApiHttpClient=new PokeApiHttpClient();

        PokeApiResponse pokeApiResponse=new PokeApiResponse();

        try {

            pokeApiResponse = pokeApiHttpClient.getPokemon(name);

            if(pokeApiResponse == null)
                throw new RuntimeException(
                        String.format("No se encontro el pokemon [%s]  ", name)
                );

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            pokeApiHttpClient.closeHttpClient();

        }

        return pokeApiResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = mapPokemon(pokeApiResponse);

        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetPokemonResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setAbilities (pokemon,pokeApiResponse);

        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setBaseExperience(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetPokemonResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();

        setHeldItem(pokemon,pokeApiResponse);

        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetPokemonResponse getId(@RequestPayload GetIdRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setId(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetPokemonResponse getName(@RequestPayload GetNameRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setName(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setLocationAreaEncounters(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        return getPokemonResponse;
    }

    private void setAbilities (Pokemon pokemon,PokeApiResponse pokeApiResponse){

        for (com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.AbilitiesItem abilitiesItem : pokeApiResponse.getAbilities()) {

            com.app.soap.ApiRestToSoapPokemon.AbilitiesItem abilitiesItemXml = new com.app.soap.ApiRestToSoapPokemon.AbilitiesItem();

            abilitiesItemXml.setSlot(abilitiesItem.getSlot());
            abilitiesItemXml.setIsHidden(abilitiesItem.is_hidden());

            Ability ability = new Ability();
            ability.setName(abilitiesItem.getAbility().getName());
            ability.setUrl(abilitiesItem.getAbility().getUrl());
            abilitiesItemXml.setAbility(ability);
            pokemon.getAbilities().add(abilitiesItemXml);

        }
    }

    private void setHeldItem (Pokemon pokemon,PokeApiResponse pokeApiResponse){

        for (com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.HeldItem heldItem : pokeApiResponse.getHeld_items()) {
            HeldItem heldItemXml = new HeldItem();
            Item item = new Item();
            item.setName(heldItem.getItem().getName());
            item.setUrl(heldItem.getItem().getUrl());
            heldItemXml.setItem(item);

            for (com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.VersionDetails versionDetails : heldItem.getVersion_details()) {

                VersionDetail versionDetail = new VersionDetail();
                Version version = new Version();
                version.setName(versionDetails.getVersion().getName());
                version.setUrl(versionDetails.getVersion().getUrl());
                versionDetail.setVersion(version);
                versionDetail.setRarity(versionDetails.getRarity());
                heldItemXml.getVersionDetails().add(versionDetail);
            }

            pokemon.getHeldItems().add(heldItemXml);

        }

    }

    private void setBaseExperience(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setBaseExperience(BigInteger.valueOf(pokeApiResponse.getBase_experience()));

    }

    private void setId(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setId(BigInteger.valueOf(pokeApiResponse.getId()));

    }

    private void setName(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setName(pokeApiResponse.getName());

    }

    private void setLocationAreaEncounters(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setLocationAreaEncounters(pokeApiResponse.getLocation_area_encounters());

    }

    public Pokemon mapPokemon(PokeApiResponse pokeApiResponse){

        Pokemon pokemon = new Pokemon();

        setAbilities (pokemon,pokeApiResponse);

        setBaseExperience(pokemon,pokeApiResponse);

        setHeldItem(pokemon,pokeApiResponse);

        setId(pokemon,pokeApiResponse);

        setName(pokemon,pokeApiResponse);

        setLocationAreaEncounters(pokemon,pokeApiResponse);

        return pokemon;
    }

}
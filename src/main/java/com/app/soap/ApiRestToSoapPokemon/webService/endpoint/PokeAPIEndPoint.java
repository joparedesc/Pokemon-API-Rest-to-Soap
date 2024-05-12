package com.app.soap.ApiRestToSoapPokemon.webService.endpoint;


import com.app.soap.ApiRestToSoapPokemon.GetPokemonRequest;
import com.app.soap.ApiRestToSoapPokemon.GetPokemonResponse;
import com.app.soap.ApiRestToSoapPokemon.Pokemon;
import com.app.soap.ApiRestToSoapPokemon.bd.entity.PokeApi;
import com.app.soap.ApiRestToSoapPokemon.bd.entity.PokeApiMongo;
import com.app.soap.ApiRestToSoapPokemon.bd.service.PokeApiMongoService;
import com.app.soap.ApiRestToSoapPokemon.bd.service.PokeApiService;
import com.app.soap.ApiRestToSoapPokemon.clientRest.client.PokeApiHttpClient;
import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import com.app.soap.ApiRestToSoapPokemon.constans.GeneralConstans;
import com.app.soap.ApiRestToSoapPokemon.webService.config.HttpServlest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.app.soap.ApiRestToSoapPokemon.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Endpoint
/**
 * Class PokeAPIEndPoint
 * Class end poit to poke api.
 * @autor jjpc
 */
public class PokeAPIEndPoint {

    /**
     * Menu DB option
     */
    @Value("${opcion-menu-bd}")
    private int MENU_DB_OPTION;

    @Autowired
    /** Http servlest */
    private HttpServlest httpServlest;

    @Autowired
    /** Poke api service */
    private PokeApiService pokeApiService;

    @Autowired
    /** Poke api mongo service */
    private PokeApiMongoService pokeApiMongoService;

    /**
     * getPokemon method
     *
     * @param name
     * @return PokeApiResponse
     */
    private PokeApiResponse getPokemon(String name) {

        PokeApiHttpClient pokeApiHttpClient = new PokeApiHttpClient();

        PokeApiResponse pokeApiResponse = new PokeApiResponse();

        try {

            pokeApiResponse = pokeApiHttpClient.getPokemon(name);

            if (pokeApiResponse == null)
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

    /**
     * getPokemon method
     *
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = mapPokemon(pokeApiResponse);

        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION, GeneralConstans.GET_POKEMON_METHOD);

        return getPokemonResponse;
    }

    /**
     * getAbilities method
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetPokemonResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setAbilities (pokemon,pokeApiResponse);

        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION,GeneralConstans.GET_ABILITIES_METHOD);

        return getPokemonResponse;
    }

    /**
     * GetPokemonResponse method
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setBaseExperience(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION,GeneralConstans.GET_BASE_EXPERIENCE_METHOD);

        return getPokemonResponse;
    }

    /**
     * getHeldItems method
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetPokemonResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();

        setHeldItem(pokemon,pokeApiResponse);

        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION,GeneralConstans.GET_HELD_ITEMS_METHOD);

        return getPokemonResponse;
    }

    /**
     * getId method
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetPokemonResponse getId(@RequestPayload GetIdRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setId(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION,GeneralConstans.GET_ID_METHOD);

        return getPokemonResponse;
    }

    /**
     * getName method
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetPokemonResponse getName(@RequestPayload GetNameRequest request) {

        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setName(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION,GeneralConstans.GET_NAME_METHOD);

        return getPokemonResponse;
    }

    /**
     * getLocationAreaEncounters method
     * @param request
     * @return GetPokemonResponse
     */
    @PayloadRoot(namespace = GeneralConstans.NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        PokeApiResponse pokeApiResponse = getPokemon(request.getName());

        Pokemon pokemon = new Pokemon();
        setLocationAreaEncounters(pokemon,pokeApiResponse);
        getPokemonResponse.setPokemon(pokemon);

        sendDataMenuBD(MENU_DB_OPTION,GeneralConstans.GET_LOCATION_AREA_ENCOUNTERS_METHOD);

        return getPokemonResponse;
    }

    /**
     * setAbilities method
     * @param pokemon
     * @param pokeApiResponse
     */
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

    /**
     * setHeldItem method
     * @param pokemon
     * @param pokeApiResponse
     */
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

    /**
     * setBaseExperience method
     * @param pokemon
     * @param pokeApiResponse
     */
    private void setBaseExperience(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setBaseExperience(BigInteger.valueOf(pokeApiResponse.getBase_experience()));

    }

    /**
     * setId method
     * @param pokemon
     * @param pokeApiResponse
     */
    private void setId(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setId(BigInteger.valueOf(pokeApiResponse.getId()));

    }

    /**
     * setName method
     * @param pokemon
     * @param pokeApiResponse
     */
    private void setName(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setName(pokeApiResponse.getName());

    }

    /**
     * setLocationAreaEncounters method
     * @param pokemon
     * @param pokeApiResponse
     */
    private void setLocationAreaEncounters(Pokemon pokemon,PokeApiResponse pokeApiResponse){

        pokemon.setLocationAreaEncounters(pokeApiResponse.getLocation_area_encounters());

    }

    /**
     * mapPokemon method
     * @param pokeApiResponse
     * @return Pokemon
     */
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

    /**
     * sendDataMongoBD method
     * @param methodName
     */
    public void sendDataMongoBD(String methodName){

        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();

        LocalDateTime date = LocalDateTime.of(today, nowTime);

        PokeApiMongo pokeApi=new PokeApiMongo();
        pokeApi.setIpOrigin(httpServlest.getIP());
        pokeApi.setRequestDate(date);
        pokeApi.setMethod(methodName);
        pokeApiMongoService.savePokeApiMongo(pokeApi);

    }

    /**
     * sendDataJPADB method
     * @param methodName
     */
    public void sendDataJPADB(String methodName){

        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();

        LocalDateTime date = LocalDateTime.of(today, nowTime);

        PokeApi pokeApi=new PokeApi();
        pokeApi.setIpOrigin(httpServlest.getIP());
        pokeApi.setRequestDate(date);
        pokeApi.setMethod(methodName);
        pokeApiService.savePokeApiRequest(pokeApi);

    }

    /**
     * sendDataMenuBD method
     * @param optionTypeDB
     * @param methodName
     */
    public void sendDataMenuBD(int optionTypeDB,String methodName){

        if(optionTypeDB==1)
            sendDataJPADB(methodName);
        else if(optionTypeDB==2)
            sendDataMongoBD(methodName);

    }

}
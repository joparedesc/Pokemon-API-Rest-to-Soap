package com.app.soap.ApiRestToSoapPokemon.clientRest.client;

import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import com.app.soap.ApiRestToSoapPokemon.constans.GeneralConstans;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * PokeApiHttpClient HttpClient class.
 * @author jjpc
 */
public class PokeApiHttpClient {

    /** httpClient CloseableHttpClient propertie */
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * getPokemon method.
     * Method to get pokemon by name.
     * @param pokemonName string.
     * @return PokeApiResponse class.
     * @throws Exception
     */
    public PokeApiResponse getPokemon(String pokemonName) throws Exception {

        PokeApiResponse pokeApiResponse = new PokeApiResponse();

        String result=sendGetHttpClient(GeneralConstans.URL_API_POKEMON + GeneralConstans.PATH_POKEMON,pokemonName);

        Gson gson = new Gson();

        pokeApiResponse = gson.fromJson(result, PokeApiResponse.class);

        return pokeApiResponse;

    }

    /**
     * sendGetHttpClient method.
     * Method to send request by http client with path variable.
     * @param URL
     * @param pathVariable
     * @return String result
     * @throws Exception
     */
    private String sendGetHttpClient(String URL,String pathVariable)throws Exception{

        HttpGet requestGet = new HttpGet(URL + pathVariable);

        try (CloseableHttpResponse response = httpClient.execute(requestGet)) {

            if (response.getStatusLine().getStatusCode() == 200) {
                
                HttpEntity entity = response.getEntity();
                String result=EntityUtils.toString(entity);
                return result;

            }
        }

        return null;
    }

    /**
     * closeHttpClient method.
     * Method to close http client instance.
     */
    public void closeHttpClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

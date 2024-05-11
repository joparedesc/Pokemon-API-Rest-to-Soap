package com.app.soap.ApiRestToSoapPokemon.clientRest.client;

import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;



public class PokeApiHttpClient {

    private final String URL_EXTERNAL="https://pokeapi.co/api/v2";

    private final String PATH_POKEMON="/pokemon/";

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public PokeApiResponse getPokemon(String pokemonName) throws Exception {

        HttpGet requestGet = new HttpGet(URL_EXTERNAL + PATH_POKEMON + pokemonName);

        PokeApiResponse pokeApiResponse = new PokeApiResponse();

        String result=sendGetHttpClient(URL_EXTERNAL + PATH_POKEMON,pokemonName);

        Gson gson = new Gson();

        pokeApiResponse = gson.fromJson(result, PokeApiResponse.class);

        return pokeApiResponse;

    }

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

    public void closeHttpClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

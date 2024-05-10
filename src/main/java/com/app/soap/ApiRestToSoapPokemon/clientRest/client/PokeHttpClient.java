package com.app.soap.ApiRestToSoapPokemon.clientRest.client;

import com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response.PokeApiResponse;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class PokeHttpClient {

    @Value("${url-external.poke-api-path}")
    private String URL_EXTERNAL;

    @Value("${url-external.pokemon}")
    private String PATH_POKEMON;

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private void closeHttpClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokeApiResponse getPokemon(String pokemonName) throws Exception {

        HttpGet requestGet = new HttpGet(URL_EXTERNAL + PATH_POKEMON + pokemonName);

        PokeApiResponse pokeApiResponse = new PokeApiResponse();

        String result=sendGetHttpClient(URL_EXTERNAL + PATH_POKEMON,pokemonName);

        try {

            Gson gson = new Gson();
            pokeApiResponse = gson.fromJson(result, PokeApiResponse.class);
            return pokeApiResponse;

        }catch (Exception e){
            return null;
        }

    }

    private String sendGetHttpClient(String URL,String pathVariable)throws Exception{

        HttpGet requestGet = new HttpGet(URL + pathVariable);

        try (CloseableHttpResponse response = httpClient.execute(requestGet)) {

            if (response.getStatusLine().getStatusCode() == 200) {
                
                HttpEntity entity = response.getEntity();
                String result=EntityUtils.toString(entity);
                return result;

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}

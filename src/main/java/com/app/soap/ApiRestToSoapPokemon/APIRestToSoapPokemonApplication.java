package com.app.soap.ApiRestToSoapPokemon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
/**
 *  APIRestToSoapPokemonApplication Application class.
 * @autor jjpc
 */
public class APIRestToSoapPokemonApplication {

    /**
     * Main method.
     * Method to execute application.
     * @param args
     */
    public static void main(String [] args){

        SpringApplication.run(APIRestToSoapPokemonApplication.class,args);

    }
}

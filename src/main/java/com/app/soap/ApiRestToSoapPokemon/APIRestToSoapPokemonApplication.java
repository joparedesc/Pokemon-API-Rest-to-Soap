package com.app.soap.ApiRestToSoapPokemon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class APIRestToSoapPokemonApplication {

    public static void main(String [] agrs){

        SpringApplication.run(APIRestToSoapPokemonApplication.class,agrs);
    }
}

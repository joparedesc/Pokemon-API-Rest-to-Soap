package com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokeApiResponse {

    private List<AbilitiesItem> abilities;

    private int base_experience;

    private List<HeldItem> held_items;

    private int id;

    private String location_area_encounters;

    private String name;
}

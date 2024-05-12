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
/**
 * PokeApiResponse class.
 * Class PokeApi response.
 * @autor jjpc
 */
public class PokeApiResponse {

    /** Property Abilities list pokemon response */
    private List<AbilitiesItem> abilities;

    /** Property Base experience pokemon response */
    private int base_experience;

    /** Property held_items list pokemon response */
    private List<HeldItem> held_items;

    /** Property id pokemon response */
    private int id;

    /** Property location area encounters pokemon response */
    private String location_area_encounters;

    /** Property name pokemon response */
    private String name;

}

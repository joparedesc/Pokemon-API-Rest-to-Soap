package com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Item class
 * Class item of pokemon.
 * @autor jjpc.
 */
public class Item{

	/** Name item pokemon property */
	private String name;

	/** Url item pokemon property */
	private String url;

}

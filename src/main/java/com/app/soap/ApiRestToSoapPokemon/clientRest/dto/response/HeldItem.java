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
 * HeldItem class.
 * Class Held item of pokemon.
 * @autor jjpc.
 */
public class HeldItem {

	/** Item pokemon property  */
	private Item item;

	/** List<VersionDetails> pokemon property */
	private List<VersionDetails> version_details;

}
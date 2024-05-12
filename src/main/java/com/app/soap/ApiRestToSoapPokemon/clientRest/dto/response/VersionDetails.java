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
 * VersionDetails class.
 * Class version details pokemon.
 */
public class VersionDetails {

	/** Property version pokemon version details */
	private Version version;

	/** Property rarity pokemon version details */
	private int rarity;

}

package com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionDetails {

	private Version version;

	private int rarity;
}

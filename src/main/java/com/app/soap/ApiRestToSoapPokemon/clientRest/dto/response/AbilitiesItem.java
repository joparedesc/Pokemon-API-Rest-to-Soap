package com.app.soap.ApiRestToSoapPokemon.clientRest.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbilitiesItem{

	private boolean is_hidden;

	private Ability ability;

	private int slot;
}

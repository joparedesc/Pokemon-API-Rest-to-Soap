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
 * AbilitiesItem class.
 * Class of Abilities Item Pokemon.
 * @autor jjpc
 */
public class AbilitiesItem{

	/** Property is_hidden of AbilitiesItem pokemon */
	private boolean is_hidden;

	/** Property ability of pokemon */
	private Ability ability;

	/** Property slot pokemon */
	private int slot;
}

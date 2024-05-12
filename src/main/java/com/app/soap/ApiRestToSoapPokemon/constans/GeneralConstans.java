package com.app.soap.ApiRestToSoapPokemon.constans;

/**
 * GeneralConstans constants class.
 * @author jjpc
 */
public class GeneralConstans {

    /** Pokemon api URL */
    public static final String URL_API_POKEMON ="https://pokeapi.co/api/v2";

    /** Pokemon path */
    public static final String PATH_POKEMON="/pokemon/";

    /** Name space uri */
    public static final String NAMESPACE_URI = "http://joparedescano.org/pokeapi";

    /** Name port type */
    public static final String PORT_TYPE_NAME = "PokeApiSchemaPort";

    /** Location uri */
    public static final String LOCATION_URI = "/ws";

    /** Mapping url */
    public static final String URL_MAPPING = "/ws/*";

    /** XSD path */
    public static final String PATH_XSD = "xsd/pokeapi.xsd";

    /** Get pokemon method name*/
    public static final String GET_POKEMON_METHOD="GET_POKEMON_METHOD";

    /** Get abilities method name */
    public static final String GET_ABILITIES_METHOD="GET_ABILITIES_METHOD";

    /** Get base experience method name*/
    public static final String GET_BASE_EXPERIENCE_METHOD="GET_BASE_EXPERIENCE_METHOD";

    /** Get held items method name*/
    public static final String GET_HELD_ITEMS_METHOD="GET_HELD_ITEMS_METHOD";

    /** Get id method name */
    public static final String GET_ID_METHOD="GET_ID_METHOD";

    /** Get name method name */
    public static final String GET_NAME_METHOD="GET_NAME_METHOD";

    /** Get location area encounters method name */
    public static final String GET_LOCATION_AREA_ENCOUNTERS_METHOD="GET_LOCATION_AREA_ENCOUNTERS_METHOD";

}

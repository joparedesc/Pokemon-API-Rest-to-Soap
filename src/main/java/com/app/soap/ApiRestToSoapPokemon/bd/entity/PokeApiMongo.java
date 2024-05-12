package com.app.soap.ApiRestToSoapPokemon.bd.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "requestPokeApi")
/**
 * PokeApi class.
 * Document PokeApiMongo to Mongo DB
 * @autor jjpc
 */
public class PokeApiMongo implements Serializable {

    @Id
    /** Id property */
    private int id;

    /** IpOrigin property */
    private String ipOrigin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", locale = "GMT-5")
    /** RequestDate property */
    private LocalDateTime requestDate;

    /** Method property */
    private String method;


}

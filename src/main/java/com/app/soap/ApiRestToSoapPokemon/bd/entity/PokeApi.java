package com.app.soap.ApiRestToSoapPokemon.bd.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
/**
 * PokeApi class.
 * Entity PokeApi to JPA DB
 * @autor jjpc
 */
public class PokeApi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    /** Id property */
    private Long id;

    @Column(name = "ORIGIN_IP")
    /** IpOrigin property */
    private String ipOrigin;

    @Column(name = "REQUEST_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", locale = "GMT-5")
    /** RequestDate property */
    private LocalDateTime requestDate;

    @Column(name = "METHOD")
    /** Method property */
    private String method;


}

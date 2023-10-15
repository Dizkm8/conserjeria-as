/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * The Persona class.
 *
 * @author Diego Urrutia-Astorga.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Persona extends BaseModel {

    /**
     * The RUT.
     */
    @NotNull
    @Getter
    private String rut;

    /**
     * The Nombre.
     */
    @NotNull
    @Getter
    private String nombre;

    /**
     * The Apellidos.
     */
    @NotNull
    @Getter
    private String apellidos;

    /**
     * The Email.
     */
    @NotNull
    @Getter
    private String email;

    /**
     * The Telefono.
     */
    @NotNull
    @Getter
    private String telefono;

}

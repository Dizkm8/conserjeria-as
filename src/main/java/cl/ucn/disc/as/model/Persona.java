/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * The Persona class.
 *
 * @author Diego Urrutia-Astorga.
 * @author David Araya Cádiz
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Persona extends BaseModel {


    public Persona(@NonNull String rut,
                   @NonNull String nombre,
                   @NonNull String apellidos,
                   @NonNull String email, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.contratos = new ArrayList<>();
    }

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

    @OneToMany(mappedBy = "persona")
    @Getter
    private List<Contrato> contratos;

}

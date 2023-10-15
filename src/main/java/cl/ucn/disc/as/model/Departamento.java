package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * The Edificio class.
 *
 * @author David Araya Cádiz
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Departamento extends BaseModel {

    @NotNull
    @Getter
    private Integer numero;

    @NotNull
    @Getter
    private Integer piso;

    @ManyToOne
    @Getter
    @Setter
    private Edificio edificio;
}

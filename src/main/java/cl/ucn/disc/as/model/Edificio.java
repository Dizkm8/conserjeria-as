package cl.ucn.disc.as.model;

import cl.ucn.disc.as.exceptions.IllegalDomainException;
import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.util.List;

/**
 * The Edificio class.
 *
 * @author David Araya Cádiz
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Edificio extends BaseModel {

    @NotNull
    @Getter
    private String nombre;

    @NotNull
    @Getter
    private String direccion;

    @NotNull
    @Getter
    @Setter
    private List<Departamento> departamentos;

    public void add(Departamento departamento) {
        if (departamento == null) throw new IllegalDomainException("Department cannot be null");
        this.departamentos.add(departamento);
    }


}

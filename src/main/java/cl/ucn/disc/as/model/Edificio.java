package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * The Edificio class.
 *
 * @author David Araya Cádiz
 */
@ToString(callSuper = true)
@Entity
public class Edificio extends BaseModel {

    @Builder
    public Edificio(@NonNull String nombre, @NonNull String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.departamentos = new ArrayList<>();
    }

    @NotNull
    @Getter
    private String nombre;

    @NotNull
    @Getter
    private String direccion;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL) // Add cascade attribute
    @Getter
    private List<Departamento> departamentos;

    public void add(@NonNull Departamento departamento) {
        this.departamentos.add(departamento);
    }


}

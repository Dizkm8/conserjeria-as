package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Instant;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Contrato extends BaseModel {

    public Contrato(Instant fechaPago, Persona persona, Departamento departamento) {
        if (fechaPago == null) throw new IllegalArgumentException("fechaPago cannot be null");
        if (persona == null) throw new IllegalArgumentException("persona cannot be null");
        if (departamento == null) throw new IllegalArgumentException("departamento cannot be null");
        this.fechaPago = fechaPago;
        this.persona = persona;
        this.departamento = departamento;
    }

    @NotNull
    @Getter
    private Instant fechaPago;

    @NotNull
    @Getter
    private Persona persona;

    @NotNull
    @Getter
    private Departamento departamento;

    @NotNull
    @Getter
    private Pago pagos;
}

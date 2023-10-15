package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
public class Contrato extends BaseModel {

    public Contrato(@org.jetbrains.annotations.NotNull Instant fechaPago,
                    @org.jetbrains.annotations.NotNull Persona persona,
                    @org.jetbrains.annotations.NotNull Departamento departamento) {
        this.fechaPago = fechaPago;
        this.persona = persona;
        this.departamento = departamento;
        this.pagos = new ArrayList<>();
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
    private List<Pago> pagos;
}

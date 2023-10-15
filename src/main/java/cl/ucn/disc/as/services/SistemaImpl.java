package cl.ucn.disc.as.services;

import cl.ucn.disc.as.model.*;
import io.ebean.Database;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Builder
public class SistemaImpl implements Sistema {

    @NotNull
    private Database database;

    @Override
    public Edificio add(Edificio edificio) {
        // Save the Edificio in the database
        database.save(edificio);
        return edificio;
    }

    @Override
    public Persona add(Persona persona) {
        return null;
    }

    @Override
    public Departamento addDepartamento(Departamento departamento, Edificio edificio) {
        return null;
    }

    @Override
    public Departamento addDepartamento(Departamento departamento, Long idEdificio) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago) {
        return null;
    }

    @Override
    public List<Contrato> getContratos() {
        return null;
    }

    @Override
    public List<Persona> getPersonas() {
        return null;
    }

    @Override
    public List<Pago> getPagos(String rut) {
        return null;
    }
}

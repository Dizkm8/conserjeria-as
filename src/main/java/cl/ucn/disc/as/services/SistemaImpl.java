package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
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
        // Persistence Operations
        database.save(edificio);

        // Use-Case Operations
        return edificio;
    }

    @Override
    public Persona add(Persona persona) {
        // Persistence Operations
        database.save(persona);

        // Use-Case Operations
        return persona;
    }

    @Override
    public Departamento addDepartamento(Departamento departamento, Edificio edificio) {
        // Use-Case Operations
        edificio.add(departamento);

        // Persistence Operations
        database.save(edificio);

        return departamento;
    }


    @Override
    public Departamento addDepartamento(Departamento departamento, Long idEdificio) {
        Edificio foundEdificio = this.findEdificioById(idEdificio);

        return this.addDepartamento(departamento, foundEdificio);
    }

    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        Contrato contrato = Contrato.builder()
                .departamento(departamento)
                .persona(duenio)
                .fechaPago(fechaPago)
                .build();
        database.save(contrato);
        return contrato;
    }


    @Override
    public Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago) {
        Departamento departamento = findDepartamentoById(idDepartamento);
        Persona duenio = findPersonaById(idDuenio);
        return this.realizarContrato(duenio, departamento, fechaPago);
    }

    @Override
    public List<Contrato> getContratos() {
        //TODO: Implement offset and max rows
//        return database.find(Contrato.class).setMaxRows(20).findList();
        return database.find(Contrato.class).findList();
    }

    @Override
    public List<Persona> getPersonas() {
        //TODO: Implement offset and max rows
        return database.find(Persona.class).findList();
    }

    @Override
    public List<Pago> getPagos(String rut) {
        //TODO: Implement offset and max rows
        return database.find(Pago.class).findList();
    }

    private Edificio findEdificioById(Long idEdificio) {
        Edificio edificio = database.find(Edificio.class, idEdificio);
        if (edificio == null)
            throw new SistemaException(String.format("Do not exists any Edificio with id %o", idEdificio));
        return edificio;
    }

    private Departamento findDepartamentoById(Long idDepartamento) {
        Departamento departamento = database.find(Departamento.class, idDepartamento);
        if (departamento == null)
            throw new SistemaException(String.format("Do not exists any Departamento with id %o", idDepartamento));
        return departamento;
    }

    private Persona findPersonaById(Long idPersona) {
        Persona persona = database.find(Persona.class, idPersona);
        if (persona == null)
            throw new SistemaException(String.format("Do not exists any Persona with id %o", idPersona));
        return persona;
    }
}

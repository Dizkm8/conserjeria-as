package cl.ucn.disc.as.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PersonaGrpcServiceImpl extends PersonaGrpcServiceGrpc.PersonaGrpcServiceImplBase {

    @Override
    public void retrieve(PersonaGrpcRequest request, StreamObserver<PersonaGrpcResponse> responseObserver) {
        log.debug("Retrieving PersonaGrpcRequest ..");
        PersonaGrpc personaGrpc = PersonaGrpc.newBuild()
                .setRut("207676918")
                .setNombre("David")
                .setApellido("Araya")
                .setEdad(22)
                .setDireccion("Calle 1")
                .setTelefono("123456789")
                .build();
        responseObserver.onNext(PersonaGrpcResponse.newBuilder()
                .setPersonaGrpc(personaGrpc)
                .build());
        responseObserver.onCompleted();
    }
}

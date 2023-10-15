import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.services.Sistema;
import cl.ucn.disc.as.services.SistemaImpl;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {

    public static void main(String[] args) {

        Database db = DB.getDefault();
        Sistema sistema = new SistemaImpl(db);


        Edificio edificio = Edificio.builder()
                .nombre("Edificio 1")
                .direccion("Dirección 1")
                .build();

        Edificio createdEdificio = sistema.add(edificio);
        log.debug("Edificio Created ${}", createdEdificio);
    }
}

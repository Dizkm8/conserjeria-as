package cl.ucn.disc.as.ui;

import io.javalin.Javalin;

/**
 * The Routes Configurator.
 * @author David Araya Cádiz
 */
public interface RoutesConfigurator {




    /**
     * Configure the routes.
     * @param javalin to use.
     */
    void configure(Javalin javalin);
}

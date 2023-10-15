package cl.ucn.disc.as.exceptions;

/**
 * The Domain Violation Exception Class
 *
 * @Author David Araya Cádiz
 */
public class IllegalDomainException extends RuntimeException {

    /**
     * The constructor.
     *
     * @param message message to log
     */
    public IllegalDomainException(String message) {
        super(message);
    }
}
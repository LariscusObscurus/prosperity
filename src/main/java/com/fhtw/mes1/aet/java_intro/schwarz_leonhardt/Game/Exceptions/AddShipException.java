package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.Exceptions;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 17.08.15
 */
public class AddShipException extends Exception {
    public AddShipException() {
        super();
    }

    public AddShipException(String message) {
        super(message);
    }

    public AddShipException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddShipException(Throwable cause) {
        super(cause);
    }

}

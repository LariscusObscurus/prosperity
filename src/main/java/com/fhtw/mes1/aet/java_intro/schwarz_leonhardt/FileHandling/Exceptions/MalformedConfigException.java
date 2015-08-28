package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.FileHandling.Exceptions;

/**
 * @author Leonhardt Schwarz <es15m009@technikum-wien.at>
 * @since 29.08.15
 */
public class MalformedConfigException extends Throwable {
    public MalformedConfigException() {
        super();
    }

    public MalformedConfigException(String message) {
        super(message);
    }

    public MalformedConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedConfigException(Throwable cause) {

    }
}

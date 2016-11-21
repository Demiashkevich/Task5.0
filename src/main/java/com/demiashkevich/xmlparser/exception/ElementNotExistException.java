package com.demiashkevich.xmlparser.exception;

public class ElementNotExistException extends Exception{

    public ElementNotExistException() {
        super();
    }

    public ElementNotExistException(String message) {
        super(message);
    }

    public ElementNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotExistException(Throwable cause) {
        super(cause);
    }

}

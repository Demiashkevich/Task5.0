package com.demiashkevich.xmlparser.exception;

public class CardBuilderNotFoundException extends Exception {

    public CardBuilderNotFoundException() {
        super();
    }

    public CardBuilderNotFoundException(String message) {
        super(message);
    }

    public CardBuilderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardBuilderNotFoundException(Throwable cause) {
        super(cause);
    }
}

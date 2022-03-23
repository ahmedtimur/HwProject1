package com.company.exceptions;

public class NoSuchIdException extends RuntimeException {
    public NoSuchIdException() {
        super();
    }

    public NoSuchIdException(String message) {
        super(message);
    }
}

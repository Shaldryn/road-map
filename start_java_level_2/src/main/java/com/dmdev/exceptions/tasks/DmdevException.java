package com.dmdev.exceptions.tasks;

public class DmdevException extends RuntimeException {//extends Exception {
    public DmdevException(String message) {
        super(message);
    }

    public DmdevException(Throwable cause) {
        super(cause);
    }
}

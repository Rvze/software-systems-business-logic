package com.nmakarov.blps.utils;

public class APIException extends RuntimeException {
    private final int status;

    public APIException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

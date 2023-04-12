package com.nmakarov.blps.utils;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public final class ExceptionsUtils {

    public static APIException ex(HttpStatus status, String message) {
        return new APIException(message, status.value());
    }

    public static APIException notFound(String message) {
        return ex(HttpStatus.NOT_FOUND, message);
    }

    public static APIException badRequest(String message) {
        return ex(HttpStatus.BAD_REQUEST, message);
    }

    public static <T extends Throwable> void ifThrow(
            boolean val, Supplier<? extends T> exceptionSupplier
    ) throws T {
        if (val)
            throw exceptionSupplier.get();
    }
}

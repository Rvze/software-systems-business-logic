package com.nmakarov.blps.utils;

import org.springframework.http.HttpStatus;

public final class ExceptionsUtils {

    public static APIException ex(HttpStatus status, String message) {
        return new APIException(message, status.value());
    }

    public static APIException notFound(String message) {
        return ex(HttpStatus.NOT_FOUND, message);
    }
}

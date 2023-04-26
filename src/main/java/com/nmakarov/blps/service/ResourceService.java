package com.nmakarov.blps.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ResourceService {
    private static final String LOCALE_RU = "ru-RU";

    private final MessageSource messageSource;

    public String localize(String resource, Object... args) {
        return messageSource.getMessage(resource, args, Locale.forLanguageTag(LOCALE_RU));
    }

    public String localize(String resource) {
        return localize(resource, (Object) null);
    }
}
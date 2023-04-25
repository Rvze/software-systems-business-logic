package com.nmakarov.blps.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class ServiceUtils {
    public static Pageable defaultSortDesc(Pageable pageable, String... fields) {
        return defaultSort(
                pageable,
                pageable.getSortOr(Sort.by(Sort.Direction.DESC, fields)));
    }


    /**
     * Возвращает {@link Pageable} с указанной сортировкой, если таковая не указана явно.
     */
    public static Pageable defaultSort(Pageable pageable, Sort sort) {
        return PageRequest.of(
                pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));
    }
}

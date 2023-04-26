package com.nmakarov.blps.data.domain;

public enum Status {
    WAIT("Ждёт оплаты"),
    DECORATED("Оформлет"),
    ON_THE_WAY("В пути"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменен");

    private final String val;

    Status(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}

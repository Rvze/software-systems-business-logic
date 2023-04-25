package com.nmakarov.blps.data.domain;

import java.util.Arrays;

public enum PaymentMethod {
    FPS(1, "Система быстрых платежей"),
    CREDIT(2, "В кредит"),
    SPLIT(3, "Яндекс сплит"),
    BY_ACC(4, "По счету");
    private final String val;
    private final Integer num;

    PaymentMethod(Integer num, String val) {
        this.num = num;
        this.val = val;
    }

    public static PaymentMethod numOf(Integer num) {
        return Arrays.stream(PaymentMethod.values()).filter(f -> f.getNum().equals(num)).findFirst().orElseThrow();
    }

    public String getVal() {
        return val;
    }

    public Integer getNum() {
        return num;
    }
}

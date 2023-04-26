package com.nmakarov.blps.data.domain;

public enum Country {
    RUSSIA("Россия"),
    CHINA("Китай");
    private final String val;

    Country(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}

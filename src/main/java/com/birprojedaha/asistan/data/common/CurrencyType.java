package com.birprojedaha.asistan.data.common;

public enum CurrencyType {
    FIAT(1), CRYPTO(2);

    private int id;

    CurrencyType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

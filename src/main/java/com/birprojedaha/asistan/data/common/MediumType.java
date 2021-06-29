package com.birprojedaha.asistan.data.common;

public enum MediumType {
    CURRENCY(1), COMMODITY(2);

    private int id;

    MediumType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

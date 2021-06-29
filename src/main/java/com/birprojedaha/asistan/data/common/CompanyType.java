package com.birprojedaha.asistan.data.common;

public enum CompanyType {
    EXCHANGE(1);

    private int id;

    CompanyType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

package com.birprojedaha.asistan.data.jdbc.dao;

import com.birprojedaha.asistan.data.common.MediumType;

public class Medium {
    protected MediumType type;

    public Medium(MediumType type) {
        this.type = type;
    }

    public Medium() {
    }

    public MediumType getType() {
        return type;
    }

    public void setType(MediumType type) {
        this.type = type;
    }
}

package com.birprojedaha.asistan.data.common;

import java.util.Arrays;

public enum NoteType {
    TEXT(1), LINK(2), REMINDER(3);

    private int id;

    NoteType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static NoteType getTypeById(int id) {

        return Arrays.stream(values())
                .filter(value -> value.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

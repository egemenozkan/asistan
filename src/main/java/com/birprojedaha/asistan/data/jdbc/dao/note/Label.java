package com.birprojedaha.asistan.data.jdbc.dao.note;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Label {
    @Id
    private long id;
    private String label;

    public Label(long id) {
        this.id = id;
    }

    public Label(String label) {
        this.label = label;
    }

    public Label() {
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label labelDao = (Label) o;
        return label.equalsIgnoreCase(labelDao.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }
}

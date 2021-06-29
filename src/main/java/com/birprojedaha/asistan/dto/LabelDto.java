package com.birprojedaha.asistan.dto;

import com.birprojedaha.asistan.data.jdbc.dao.note.Label;

import java.util.Objects;

public class LabelDto implements Comparable {
    private long id;
    private String label;

    public LabelDto(long id) {
        this.id = id;
    }

    public LabelDto(long id, String label) {
        this.id = id;
        this.label = label;
    }

    public LabelDto() {
    }

    public LabelDto(String label) {
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static Label toDao(LabelDto labelDto) {
        Label label = new Label();
        label.setId(labelDto.getId());
        label.setLabel(labelDto.getLabel());
        return label;
    }

    public static LabelDto fromDao(Label labelDao) {
        LabelDto label = new LabelDto();
        label.setId(labelDao.getId());
        label.setLabel(labelDao.getLabel());
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelDto labelDto = (LabelDto) o;
        return label.equalsIgnoreCase(labelDto.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }


    @Override
    public int compareTo(Object obj) {



        return 0;
    }
}

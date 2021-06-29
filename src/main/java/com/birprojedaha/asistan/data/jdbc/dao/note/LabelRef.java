package com.birprojedaha.asistan.data.jdbc.dao.note;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("note_label")
public class LabelRef {
    @Column("label_id")
    private long id;

    public LabelRef(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

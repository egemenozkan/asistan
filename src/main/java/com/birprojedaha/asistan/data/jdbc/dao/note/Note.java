package com.birprojedaha.asistan.data.jdbc.dao.note;

import com.birprojedaha.asistan.data.common.NoteType;
import com.birprojedaha.asistan.data.jdbc.dao.investment.CurrencyPairRef;
import com.birprojedaha.asistan.data.jdbc.dao.person.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Note {
    @Id
    private long id;
    private String payload;
    private NoteType type;

    @MappedCollection(idColumn = "note_id")
    private Set<LabelRef> labels = new HashSet<>();

    Note withId(long id) {
        Note note = new Note();
        note.setId(id);
        note.setType(type);
        note.setPayload(payload);
        return note;
    }

    public void addLabel(Label label) {
        labels.add(new LabelRef(label.getId()));
    }


    public Set<Long> getLabelIds() {
        return this.labels.stream().map(LabelRef::getId).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

}

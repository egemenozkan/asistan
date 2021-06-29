package com.birprojedaha.asistan.data.jdbc.dao.note;

import com.birprojedaha.asistan.data.jdbc.dao.person.Person;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person {
    @MappedCollection(idColumn = "author_id")
    private Set<Note> notes = new HashSet<>();


    public Author(int id) {
        super(id);
    }

    public Author() {
        super();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}

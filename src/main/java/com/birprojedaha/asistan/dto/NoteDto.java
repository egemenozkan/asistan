package com.birprojedaha.asistan.dto;

import com.birprojedaha.asistan.data.common.NoteType;
import com.birprojedaha.asistan.data.jdbc.dao.note.Author;
import com.birprojedaha.asistan.data.jdbc.dao.note.Note;

import java.util.List;

public class NoteDto {
    private long id;
    private String payload;
    private NoteType type;
    private AuthorDto author;
    private List<LabelDto> labels;


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

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public List<LabelDto> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDto> labels) {
        this.labels = labels;
    }

    public static Note toDao(NoteDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setType(noteDto.getType());
        note.setPayload(noteDto.getPayload());
        return note;
    }

    public static NoteDto fromDao(Note noteDao) {
        NoteDto note = new NoteDto();
        note.setId(noteDao.getId());
        note.setType(noteDao.getType());
        note.setPayload(noteDao.getPayload());
        return note;

    }


}

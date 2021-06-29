package com.birprojedaha.asistan.service;

import com.birprojedaha.asistan.dto.LabelDto;
import com.birprojedaha.asistan.dto.NoteDto;
import com.birprojedaha.asistan.dto.NoteFilter;

import java.util.List;

public interface IAuthorService {
    List<NoteDto> findNotesByFilter(NoteFilter noteFilter);
    NoteDto saveNote(NoteDto note);

    List<LabelDto> findNoteLabels();
}

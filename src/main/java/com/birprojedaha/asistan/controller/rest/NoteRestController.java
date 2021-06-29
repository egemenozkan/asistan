package com.birprojedaha.asistan.controller.rest;

import com.birprojedaha.asistan.dto.LabelDto;
import com.birprojedaha.asistan.dto.NoteDto;
import com.birprojedaha.asistan.dto.NoteFilter;
import com.birprojedaha.asistan.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NoteRestController {
    @Autowired
    private IAuthorService authorService;
    private final static int authorId = 25;

    @GetMapping("/notes")
    public List<NoteDto> listNotes(@RequestParam long authorId, @RequestParam(required = false) String label) {
        NoteFilter noteFilter = new NoteFilter();
        noteFilter.setAuthorId(authorId);
        noteFilter.addLabel(label);
        //TODO: other filters

        return authorService.findNotesByFilter(noteFilter);
    }

    @PostMapping("/notes")
    public NoteDto listNotes(@RequestBody NoteDto noteDto) {
        authorService.saveNote(noteDto);
        return noteDto;
    }

    @GetMapping("/notes/labels")
    public List<LabelDto> listNoteLabels() {
        return authorService.findNoteLabels();
    }

}

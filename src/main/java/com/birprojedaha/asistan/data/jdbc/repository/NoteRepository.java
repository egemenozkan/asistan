package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.note.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}

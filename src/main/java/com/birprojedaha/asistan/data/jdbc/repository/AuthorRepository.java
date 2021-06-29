package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.note.Author;
import com.birprojedaha.asistan.data.jdbc.dao.note.Label;
import com.birprojedaha.asistan.data.jdbc.dao.note.Note;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends PersonRepository<Author> {
    @Query("SELECT note.id AS id, note.type AS type, note.payload AS payload " +
            "FROM note WHERE note.author_id =:authorId AND note.closed=0")
    List<Note> findNotesById(@Param("authorId") long authorId);

    @Modifying
    @Query("UPDATE note SET payload=:payload, type=:type WHERE id= :noteId")
    boolean updateNote(@Param("payload") String payload, @Param("type") String type, @Param("noteId") long noteId);

    @Modifying
    @Query("UPDATE note SET closed = 1 WHERE id= :noteId")
    boolean deleteNote(int noteId);

    @Query("SELECT l.id, l.label FROM label l LEFT JOIN note_label nl ON nl.label_id = l.id WHERE nl.note_id =:noteId")
   List<Label> findLabelsByNoteId(@Param("noteId") long noteId);

    @Query("SELECT l.id, l.label FROM label l")
    List<Label>  findAllLabels();
}

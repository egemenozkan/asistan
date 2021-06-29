package com.birprojedaha.asistan.repository;

import com.birprojedaha.asistan.data.common.NoteType;
import com.birprojedaha.asistan.data.jdbc.dao.note.Author;
import com.birprojedaha.asistan.data.jdbc.dao.note.Label;
import com.birprojedaha.asistan.data.jdbc.dao.note.Note;
import com.birprojedaha.asistan.data.jdbc.repository.AuthorRepository;
import com.birprojedaha.asistan.data.jdbc.repository.LabelRepository;
import com.birprojedaha.asistan.dto.AuthorDto;
import com.birprojedaha.asistan.dto.LabelDto;
import com.birprojedaha.asistan.dto.NoteDto;
import com.birprojedaha.asistan.service.IAuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    LabelRepository labelRepository;

    @Autowired
    IAuthorService authorService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    void saveNote() {
        Author author = new Author();
        author.setFirstName("Egemen3");
        Note note = new Note();
        note.setType(NoteType.TEXT);
        note.setPayload("FirstNote");
        author.addNote(note);
        Label label = new Label();
        label.setLabel("deneme");
        note.addLabel(label);
        authorRepository.save(author);
    }

    @Test
    void findById() {
        Optional<Author> author = authorRepository.findById(25);
        System.out.println(author);
    }

    @Test
    void findNotesById() {
        List<Note> notes = authorRepository.findNotesById(25);
        System.out.println(notes);
    }

    @Test
    void insertNote() {
        NoteDto note = new NoteDto();
        note.setType(NoteType.TEXT);
        note.setPayload("Egemen");
        note.setAuthor(new AuthorDto(25));
        note.setLabels(List.of(new LabelDto(0,"l3"), new LabelDto(0,"l4")));
        authorService.saveNote(note);

    }

    @Test
    void updateNote() {
        Note note = new Note();
        note.setType(NoteType.TEXT);
        note.setPayload("Egemen2");
        boolean result = authorRepository.updateNote(note.getPayload(), note.getType().toString(), 3);
        System.out.println(result);
    }

    @Test
    void deleteNote() {

        boolean result = authorRepository.deleteNote(18);


        System.out.println(result);
    }


    @Test
    void insertNoteLabel() {
        Optional<Label> label1 = labelRepository.findByLabel("egemen5");
        System.out.println(label1.get().getId());
//    Label label = labelRepository.save(new Label("egemen5"));
//        System.out.println(label.getId() + " " + label.getLabel());
    }

    @Test
    void insertGetId() {
        String INSERT_SQL = "INSERT INTO label(label) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_SQL, new String[] {"id"});
                        ps.setString(1, "l2");
                        return ps;
                    }
                },
                keyHolder);
        System.out.println(keyHolder.getKey());

    }
}

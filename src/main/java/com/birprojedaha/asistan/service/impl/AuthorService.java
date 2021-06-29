package com.birprojedaha.asistan.service.impl;

import com.birprojedaha.asistan.data.jdbc.dao.note.Label;
import com.birprojedaha.asistan.data.jdbc.dao.note.Note;
import com.birprojedaha.asistan.data.jdbc.repository.AuthorRepository;
import com.birprojedaha.asistan.data.jdbc.repository.LabelRepository;
import com.birprojedaha.asistan.dto.LabelDto;
import com.birprojedaha.asistan.dto.NoteDto;
import com.birprojedaha.asistan.dto.NoteFilter;
import com.birprojedaha.asistan.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    LabelRepository labelRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<NoteDto> findNotesByFilter(NoteFilter noteFilter) {
        List<Note> notes = authorRepository.findNotesById(noteFilter.getAuthorId());
        List<NoteDto> noteDtos = notes.stream().map(n -> NoteDto.fromDao(n)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(noteDtos)) {
            for (NoteDto note : noteDtos) {
                List<LabelDto> labels = authorRepository.findLabelsByNoteId(note.getId())
                        .stream().map(n -> LabelDto.fromDao(n)).collect(Collectors.toList());
                note.setLabels(labels);
            }
        }

        Iterator iterator = noteDtos.iterator();
        while (iterator.hasNext()) {
            NoteDto note = (NoteDto) iterator.next();
            if (!CollectionUtils.isEmpty(noteFilter.getLabels())) {
                int size = note.getLabels().stream().filter(label -> noteFilter.getLabels().contains(label)).collect(Collectors.toList()).size();
                if (size == 0) {
                    iterator.remove();
                }
            }

        }


        return noteDtos;
    }

    @Override
    public NoteDto saveNote(NoteDto noteDto) {
        if (noteDto.getId() == 0) {
            List<Label> noteLabels = authorRepository.findLabelsByNoteId(noteDto.getId());
            List<Long> newLabelIds = new ArrayList<Long>();
            noteDto.getLabels().stream().filter(label -> !noteLabels.contains(label))
                    .collect(Collectors.toList())
                    .forEach((labelDto -> {
                        Optional<Label> labelInDb = labelRepository.findByLabel(labelDto.getLabel());
                        if (labelInDb.isPresent()) {
                            newLabelIds.add(labelInDb.get().getId());
                        } else {
                            Label newLabel = labelRepository.save(labelDto.toDao(labelDto));
                            newLabelIds.add(newLabel.getId());
                        }
                    }));
            long noteId = this.insertNote(noteDto);
            noteDto.setId(noteId);
            this.insertNoteLabels(noteId, newLabelIds);
        } else {
            authorRepository.updateNote(noteDto.getPayload(), noteDto.getType().toString(), noteDto.getId());
        }
        return noteDto;
    }

    @Override
    public List<LabelDto> findNoteLabels() {
        return authorRepository.findAllLabels().stream().map(label -> LabelDto.fromDao(label)).collect(Collectors.toList());
    }

    /*
        @Modifying
        @Query("INSERT INTO note(payload, type, author_id) VALUES(:payload, :type, :authorId)")
        Integer insertNote(@Param("payload") String payload, @Param("type") String type, @Param("authorId") int authorId);


     */
    @Transactional
    long insertNote(NoteDto note) {
        String INSERT_SQL = "INSERT INTO note(payload, type, author_id) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setString(1, note.getPayload());
                        ps.setString(2, note.getType().toString());
                        ps.setLong(3, note.getAuthor().getId());
                        return ps;
                    }
                },
                keyHolder);
        return keyHolder.getKey().longValue();

    }

    @Transactional
    long insertNoteLabel(LabelDto label) {
        String INSERT_SQL = "INSERT INTO label(label) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setString(1, label.getLabel());
                        return ps;
                    }
                },
                keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Transactional
    void insertNoteLabels(long noteId, List<Long> labelIds) {
        labelIds.forEach(id -> {
            jdbcTemplate.execute("INSERT INTO note_label(note_id, label_id) VALUES('" + String.valueOf(noteId) + "', '" + String.valueOf(id) + "')");
        });
    }

}

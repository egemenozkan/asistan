package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.note.Label;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LabelRepository extends CrudRepository<Label, Long> {
    Optional<Label> findByLabel(String label);

}

package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.note.Note;
import com.birprojedaha.asistan.data.jdbc.dao.person.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository<T extends Person> extends CrudRepository<T, Integer> {
    @Modifying
    @Query("UPDATE address SET city =:city WHERE person_id =:personId")
    boolean updateAddress(@Param("city") String city, @Param("personId") int personId);


}

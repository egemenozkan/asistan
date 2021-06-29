package com.birprojedaha.asistan.data.jdbc.repository;

import com.birprojedaha.asistan.data.jdbc.dao.person.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query("SELECT r.id, r.name FROM role r left join person_role pr on (pr.role_id = r.id) WHERE pr.person_id")
    List<Role> findByPersonId(@Param("person_id") Integer personId);
}

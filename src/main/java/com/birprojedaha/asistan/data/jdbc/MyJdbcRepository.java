package com.birprojedaha.asistan.data.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@Component
public class MyJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public long execInsert() {
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
       return (Long) keyHolder.getKey();

    }

}

package com.birprojedaha.asistan.data.jdbc.dao;

import org.springframework.data.annotation.Id;

public class Address {
    @Id
    protected int id;
    protected String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

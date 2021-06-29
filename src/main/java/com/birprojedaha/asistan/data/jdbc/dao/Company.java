package com.birprojedaha.asistan.data.jdbc.dao;

import org.springframework.data.annotation.Id;

public class Company {
    @Id
    protected int id;
    protected String name;
    protected String website;
    protected int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

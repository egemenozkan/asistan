package com.birprojedaha.asistan.dto;

public class PersonDto {
    protected int id;
    protected String firstName;
    protected String lastName;

    public PersonDto(int id) {
        this.id = id;
    }

    public PersonDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

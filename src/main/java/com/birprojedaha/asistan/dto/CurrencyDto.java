package com.birprojedaha.asistan.dto;

import com.birprojedaha.asistan.data.jdbc.dao.investment.Currency;

public class CurrencyDto {
    protected int id;
    protected String name;
    protected String abbreviation;
    protected int type;

    public CurrencyDto(int id, String name, String abbreviation, int type) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.type = type;
    }

    public CurrencyDto() {
    }

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static CurrencyDto fromDao(Currency currency) {
        return new CurrencyDto(currency.getId(), currency.getName(), currency.getAbbreviation(), currency.getType());
    }
}

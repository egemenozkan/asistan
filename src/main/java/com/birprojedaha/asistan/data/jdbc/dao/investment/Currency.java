package com.birprojedaha.asistan.data.jdbc.dao.investment;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

;

@Table("currency")
public class Currency {

    @Id
    protected int id;
    protected String name;
    protected String abbreviation;
    protected int type;

    @MappedCollection(idColumn = "base_id")
    protected Set<CurrencyPairRef> pairs = new HashSet<>();

    public void addPair(Currency currency) {
        pairs.add(new CurrencyPairRef(currency.getId()));
    }

    public Set<Integer> getPairIds() {
        return this.pairs.stream().map(CurrencyPairRef::getId).collect(Collectors.toSet());
    }


    public static Currency of(int id) {
        Currency currency = new Currency();
        currency.setId(id);
        return currency;
    }


    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

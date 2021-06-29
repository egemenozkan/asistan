package com.birprojedaha.asistan.data.jdbc.dao.investment;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("currency_pair")
public class CurrencyPairRef {
    @Column("currency_id")
    private int id;

    public CurrencyPairRef(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}

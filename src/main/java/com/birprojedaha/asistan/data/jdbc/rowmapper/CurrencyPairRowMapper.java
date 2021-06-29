package com.birprojedaha.asistan.data.jdbc.rowmapper;

import com.birprojedaha.asistan.data.jdbc.dao.investment.Currency;
import com.birprojedaha.asistan.data.jdbc.dao.investment.CurrencyPair;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyPairRowMapper implements RowMapper<CurrencyPair> {
    @Override
    public CurrencyPair mapRow(ResultSet rs, int rowNum) throws SQLException {
        CurrencyPair currencyPair = new CurrencyPair();
        Currency currency = new Currency();
        currency.setId(rs.getInt("currency.id"));
        currency.setName(rs.getString("currency.name"));
        currency.setAbbreviation(rs.getString("currency.abbreviation"));
        currency.setType(rs.getInt("currency.type"));
        Currency baseCurrency = new Currency();
        baseCurrency.setId(rs.getInt("baseCurrency.id"));
        baseCurrency.setName(rs.getString("baseCurrency.name"));
        baseCurrency.setAbbreviation(rs.getString("baseCurrency.abbreviation"));
        baseCurrency.setType(rs.getInt("baseCurrency.type"));
        currencyPair.setCurrency(currency);
        currencyPair.setBaseCurrency(currency);
        return currencyPair;
    }
}
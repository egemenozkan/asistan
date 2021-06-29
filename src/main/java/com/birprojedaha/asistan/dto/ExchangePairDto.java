package com.birprojedaha.asistan.dto;

import com.birprojedaha.asistan.data.jdbc.dao.investment.Currency;

public class ExchangePairDto {
    private CurrencyDto currency;
    private CurrencyDto baseCurrency;

    public ExchangePairDto(CurrencyDto baseCurrency, CurrencyDto currency) {
        this.currency = currency;
        this.baseCurrency = baseCurrency;
    }

    public CurrencyDto getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDto currency) {
        this.currency = currency;
    }

    public CurrencyDto getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(CurrencyDto baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public static ExchangePairDto fromDao(Currency baseCurrency, Currency currency) {
        return new ExchangePairDto(CurrencyDto.fromDao(baseCurrency), CurrencyDto.fromDao(currency));
    }

}
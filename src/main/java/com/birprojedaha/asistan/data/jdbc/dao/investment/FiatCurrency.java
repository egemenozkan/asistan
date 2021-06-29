package com.birprojedaha.asistan.data.jdbc.dao.investment;

import com.birprojedaha.asistan.data.common.CurrencyType;

public class FiatCurrency extends Currency {
    public FiatCurrency() {
        super.setType(CurrencyType.FIAT.getId());
    }
}

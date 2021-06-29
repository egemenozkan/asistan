package com.birprojedaha.asistan.data.jdbc.dao.investment;

import com.birprojedaha.asistan.data.common.CurrencyType;

public class CryptoCurrency extends Currency {
    public CryptoCurrency() {
        super.setType(CurrencyType.CRYPTO.getId());
    }
}

package com.birprojedaha.asistan.service;

import com.birprojedaha.asistan.dto.CurrencyDto;
import com.birprojedaha.asistan.dto.ExchangePairDto;

import java.util.List;

public interface IExchangeService {
    List<CurrencyDto> getCurrencies();
    List<ExchangePairDto> getExchangePairs();

}

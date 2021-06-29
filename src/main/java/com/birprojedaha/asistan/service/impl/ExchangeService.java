package com.birprojedaha.asistan.service.impl;

import com.birprojedaha.asistan.data.jdbc.repository.CurrencyRepository;
import com.birprojedaha.asistan.dto.CurrencyDto;
import com.birprojedaha.asistan.dto.ExchangePairDto;
import com.birprojedaha.asistan.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExchangeService implements IExchangeService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public List<CurrencyDto> getCurrencies() {
        return StreamSupport.stream(currencyRepository.findAll().spliterator(), false)
                .map(c -> {
                    return CurrencyDto.fromDao(c);
                }).collect(Collectors.toList());
    }

    @Override
    public List<ExchangePairDto> getExchangePairs() {
        return  StreamSupport.stream(currencyRepository.findAllPairs().spliterator(), false)
                .map(ce -> {
                    return ExchangePairDto.fromDao(ce.getBaseCurrency(), ce.getCurrency());
                }).collect(Collectors.toList());
    }
}

package com.birprojedaha.asistan.controller.rest;

import com.birprojedaha.asistan.dto.CurrencyDto;
import com.birprojedaha.asistan.dto.ExchangePairDto;
import com.birprojedaha.asistan.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExchangeRestController {
    @Autowired
    private IExchangeService exchangeService;

    @GetMapping("/currencies")
    public List<CurrencyDto> listCurrencies() {
        return exchangeService.getCurrencies();
    }

    @GetMapping("/currencies/pairs")
    public List<ExchangePairDto> listCurrencyPairs() {
        List<ExchangePairDto> exchangePairs = exchangeService.getExchangePairs();
        return exchangePairs;
    }


}

package com.birprojedaha.asistan.partner.btcturk;

import java.util.ArrayList;
import java.util.List;

public class TransactionRequest {
    private List<String> types = new ArrayList<>();
    private List<String> symbols = new ArrayList<>();
    private Long startDate;
    private Long endDate;

    public TransactionRequest addType(String type) {
        this.types.add(type);
        return this;
    }

    public TransactionRequest addSymbol(String symbol) {
        this.symbols.add(symbol);
        return this;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
}

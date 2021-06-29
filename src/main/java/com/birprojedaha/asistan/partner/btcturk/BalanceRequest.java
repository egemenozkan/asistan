package com.birprojedaha.asistan.partner.btcturk;

public class BalanceRequest {
    private String pairSymbol;

    public BalanceRequest(String pairSymbol) {
        this.pairSymbol = pairSymbol;
    }

    public String getPairSymbol() {
        return pairSymbol;
    }

    public void setPairSymbol(String pairSymbol) {
        this.pairSymbol = pairSymbol;
    }
}

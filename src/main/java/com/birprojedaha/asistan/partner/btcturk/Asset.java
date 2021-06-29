package com.birprojedaha.asistan.partner.btcturk;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class Asset {
    private String asset;
    private String assetName;
    private BigDecimal balance;
    private BigDecimal locked;
    private BigDecimal free;
    private BigDecimal orderFund;
    private BigDecimal requestFund;
    private int precision;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLocked() {
        return locked;
    }

    public void setLocked(BigDecimal locked) {
        this.locked = locked;
    }

    public BigDecimal getFree() {
        return free;
    }

    public void setFree(BigDecimal free) {
        this.free = free;
    }

    public BigDecimal getOrderFund() {
        return orderFund;
    }

    public void setOrderFund(BigDecimal orderFund) {
        this.orderFund = orderFund;
    }

    public BigDecimal getRequestFund() {
        return requestFund;
    }

    public void setRequestFund(BigDecimal requestFund) {
        this.requestFund = requestFund;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",  "{", "}")
                .add("asset='" + asset + "'")
                .add("assetName='" + assetName + "'")
                .add("balance=" + balance)
                .add("locked=" + locked)
                .add("free=" + free)
                .add("orderFund=" + orderFund)
                .add("requestFund=" + requestFund)
                .add("precision=" + precision)
                .toString();
    }
}

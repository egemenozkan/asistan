package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.math.BigInteger;

public class OrderFilterRequest implements Serializable {
    private static final long serialVersionUID = 7081793838315631240L;
    private BigInteger orderId;
    private String pairSymbol;
    private BigInteger startTime;
    private BigInteger endTime;
    private int page;
    private String limit;

    public OrderFilterRequest(String pairSymbol) {
        this.pairSymbol = pairSymbol;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public String getPairSymbol() {
        return pairSymbol;
    }

    public void setPairSymbol(String pairSymbol) {
        this.pairSymbol = pairSymbol;
    }

    public BigInteger getStartTime() {
        return startTime;
    }

    public void setStartTime(BigInteger startTime) {
        this.startTime = startTime;
    }

    public BigInteger getEndTime() {
        return endTime;
    }

    public void setEndTime(BigInteger endTime) {
        this.endTime = endTime;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}

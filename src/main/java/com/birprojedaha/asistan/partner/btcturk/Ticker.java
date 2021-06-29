package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

/*
{"pair":"AVAXUSDT","pairNormalized":"AVAX_USDT","timestamp":1624544571166,"last":11.326,"high":11.59,"low":10.788,"bid":11.33,"ask":11.401,
"open":11.463,"volume":20526.37,"average":11.27,"daily":-0.062,"dailyPercent":-1.2,"denominatorSymbol":"USDT","numeratorSymbol":"AVAX","order":2005}]

 */
public class Ticker implements Serializable {

    private static final long serialVersionUID = -1792657295329414664L;
    private String pair;
    private String pairNormalized;
    private String timestamp;
    private BigDecimal last;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal open;
    private BigDecimal volume;
    private BigDecimal average;
    private BigDecimal daily;
    private BigDecimal dailyPercent;
    private String denominatorSymbol;
    private String numeratorSymbol;
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getPairNormalized() {
        return pairNormalized;
    }

    public void setPairNormalized(String pairNormalized) {
        this.pairNormalized = pairNormalized;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public BigDecimal getDaily() {
        return daily;
    }

    public void setDaily(BigDecimal daily) {
        this.daily = daily;
    }

    public BigDecimal getDailyPercent() {
        return dailyPercent;
    }

    public void setDailyPercent(BigDecimal dailyPercent) {
        this.dailyPercent = dailyPercent;
    }

    public String getDenominatorSymbol() {
        return denominatorSymbol;
    }

    public void setDenominatorSymbol(String denominatorSymbol) {
        this.denominatorSymbol = denominatorSymbol;
    }

    public String getNumeratorSymbol() {
        return numeratorSymbol;
    }

    public void setNumeratorSymbol(String numeratorSymbol) {
        this.numeratorSymbol = numeratorSymbol;
    }
//    public String getBaseCurrency() {
//        return this.denominatorSymbol
//    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Ticker.class.getSimpleName() + "[", "]")
                .add("pair='" + pair + "'")
                .add("pairNormalized='" + pairNormalized + "'")
                .add("timestamp='" + timestamp + "'")
                .add("last=" + last)
                .add("high=" + high)
                .add("low=" + low)
                .add("bid=" + bid)
                .add("ask=" + ask)
                .add("open=" + open)
                .add("volume=" + volume)
                .add("average=" + average)
                .add("daily=" + daily)
                .add("dailyPercent=" + dailyPercent)
                .add("denominatorSymbol='" + denominatorSymbol + "'")
                .add("numeratorSymbol='" + numeratorSymbol + "'")
                .toString();
    }
}

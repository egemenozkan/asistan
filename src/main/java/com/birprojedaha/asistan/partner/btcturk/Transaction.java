package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.StringJoiner;

/**
 * {price=0.004510, numeratorSymbol=LTC, denominatorSymbol=BTC, orderType=buy,
 * orderId=3428398957, id=408413464, timestamp=1623319585810,
 * amount=0.37821303, fee=-0.000001, tax=0.000000}
 */
public class Transaction implements Serializable {
    private BigInteger id;
    private BigInteger orderId;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal fee;
    private BigDecimal tax;
    private String numeratorSymbol;
    private String denominatorSymbol;
    private String orderType;
    private BigInteger timestamp;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getNumeratorSymbol() {
        return numeratorSymbol;
    }

    public void setNumeratorSymbol(String numeratorSymbol) {
        this.numeratorSymbol = numeratorSymbol;
    }

    public String getDenominatorSymbol() {
        return denominatorSymbol;
    }

    public void setDenominatorSymbol(String denominatorSymbol) {
        this.denominatorSymbol = denominatorSymbol;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("id=" + id)
                .add("orderId=" + orderId)
                .add("price=" + price)
                .add("amount=" + amount)
                .add("fee=" + fee)
                .add("tax=" + tax)
                .add("numeratorSymbol='" + numeratorSymbol + "'")
                .add("denominatorSymbol='" + denominatorSymbol + "'")
                .add("orderType='" + orderType + "'")
                .toString();
    }
}

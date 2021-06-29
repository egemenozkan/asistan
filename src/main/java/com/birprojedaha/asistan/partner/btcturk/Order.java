package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringJoiner;

/*
{id=3579551853, price=59876, amount=0.01841325, quantity=0.01841325, stopPrice=0, pairSymbol=BTCUSDT, pairSymbolNormalized=BTC_USDT,
type=sell, method=limit, orderClientId=0cfdb072-973b-4346-8b89-fbbc342e7113, time=0,
updateTime=1624514832203, status=Untouched, leftAmount=0.01841325}
 */
public class Order implements Serializable {
    private BigInteger id;
    private String orderClientId;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal quantity;
    private BigDecimal stopPrice;
    private String pairSymbol;
    private String pairSymbolNormalized;
    private String type;
    private String method;
    private String time;
    private String updateTime;
    private String status;
    private BigDecimal leftAmount;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getOrderClientId() {
        return orderClientId;
    }

    public void setOrderClientId(String orderClientId) {
        this.orderClientId = orderClientId;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getPairSymbol() {
        return pairSymbol;
    }

    public void setPairSymbol(String pairSymbol) {
        this.pairSymbol = pairSymbol;
    }

    public String getPairSymbolNormalized() {
        return pairSymbolNormalized;
    }

    public void setPairSymbolNormalized(String pairSymbolNormalized) {
        this.pairSymbolNormalized = pairSymbolNormalized;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(BigDecimal leftAmount) {
        this.leftAmount = leftAmount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("orderClientId='" + orderClientId + "'")
                .add("price=" + price)
                .add("amount=" + amount)
                .add("quantity=" + quantity)
                .add("stopPrice=" + stopPrice)
                .add("pairSymbol='" + pairSymbol + "'")
                .add("pairSymbolNormalized='" + pairSymbolNormalized + "'")
                .add("type='" + type + "'")
                .add("method='" + method + "'")
                .add("time='" + time + "'")
                .toString();
    }
}

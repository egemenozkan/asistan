package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderTradeRequest implements Serializable {
    private static final long serialVersionUID = -7047877022233535330L;

    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal stopPrice;
    private String newOrderClientId;
    private String orderType;
    private String orderMethod;
    private String pairSymbol;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getNewOrderClientId() {
        return newOrderClientId;
    }

    public void setNewOrderClientId(String newOrderClientId) {
        this.newOrderClientId = newOrderClientId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPairSymbol() {
        return pairSymbol;
    }

    public void setPairSymbol(String pairSymbol) {
        this.pairSymbol = pairSymbol;
    }

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
    }
}

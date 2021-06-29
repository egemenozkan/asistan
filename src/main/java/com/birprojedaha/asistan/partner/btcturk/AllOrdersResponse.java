package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class AllOrdersResponse extends BaseResponse implements Serializable {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AllOrdersResponse.class.getSimpleName() + "[", "]")
                .add("orders=" + orders)
                .add("baseResponse=" + super.toString())
                .toString();
    }
}

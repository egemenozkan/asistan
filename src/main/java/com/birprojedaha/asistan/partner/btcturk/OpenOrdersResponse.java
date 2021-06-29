package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class OpenOrdersResponse extends BaseResponse implements Serializable {
    private List<Order> asks;
    private List<Order> bids;

    public List<Order> getAsks() {
        return asks;
    }

    public void setAsks(List<Order> asks) {
        this.asks = asks;
    }

    public List<Order> getBids() {
        return bids;
    }

    public void setBids(List<Order> bids) {
        this.bids = bids;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", OpenOrdersResponse.class.getSimpleName() + "[", "]")
                .add("asks=" + asks)
                .add("bids=" + bids)
                .add("baseResponse=" + super.toString())
                .toString();
    }
}

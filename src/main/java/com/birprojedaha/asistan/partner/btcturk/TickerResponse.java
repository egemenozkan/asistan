package com.birprojedaha.asistan.partner.btcturk;


import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class TickerResponse extends BaseResponse implements Serializable {
    private static final long serialVersionUID = -6720503003721147901L;
    List<Ticker> tickers;

    public List<Ticker> getTickers() {
        return tickers;
    }

    public void setTickers(List<Ticker> tickers) {
        this.tickers = tickers;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TickerResponse.class.getSimpleName() + "[", "]")
                .add("tickers=" + tickers)
                .add("baseResponse=" + super.toString())
                .toString();
    }
}

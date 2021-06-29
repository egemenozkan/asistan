package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class TransactionResponse  extends BaseResponse implements Serializable {
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TransactionResponse.class.getSimpleName() + "[", "]")
                .add("transactions=" + transactions)
                .add("baseResponse=" + super.toString())
                .toString();
    }
}

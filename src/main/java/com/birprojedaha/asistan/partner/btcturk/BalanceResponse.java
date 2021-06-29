package com.birprojedaha.asistan.partner.btcturk;

import java.util.List;
import java.util.StringJoiner;

public class BalanceResponse extends BaseResponse {
    private List<Asset> assets;

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BalanceResponse.class.getSimpleName() + "[", "]")
                .add("assets=" + assets)
                .add("baseResponse=" + super.toString())
                .toString();
    }
}

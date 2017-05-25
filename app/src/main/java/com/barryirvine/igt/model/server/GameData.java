package com.barryirvine.igt.model.server;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameData {
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("data")
    private List<Game> mData;

    public String getCurrency() {
        return mCurrency;
    }

    public List<Game> getData() {
        return mData;
    }
}

package com.barryirvine.igt.model.server;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Game {
    @SerializedName("name")
    private String mName;
    @SerializedName("jackpot")
    private int mJackpot;
    @SerializedName("date")
    private Date mDate;

    public String getName() {
        return mName;
    }

    public int getJackpot() {
        return mJackpot;
    }

    public Date getDate() {
        return mDate;
    }
}

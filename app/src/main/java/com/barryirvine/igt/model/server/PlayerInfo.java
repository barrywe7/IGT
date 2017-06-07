package com.barryirvine.igt.model.server;

import com.google.gson.annotations.SerializedName;

public class PlayerInfo {

    @SerializedName("name")
    private String mName;
    @SerializedName("balance")
    private int mBalance;
    @SerializedName("avatarLink")
    private String mAvatarLink;

    /* Parsed as String because not in ISO-8601 format. Assumption is that the server is
     returning a UTC date in format dd/MM/yyyy'T'HH:mm */
    @SerializedName("lastLogindate")
    private String mLastLoginDate;

    public String getName() {
        return mName;
    }

    public int getBalance() {
        return mBalance;
    }

    public String getAvatarLink() {
        return mAvatarLink;
    }

    public String getLastLoginDate() {
        return mLastLoginDate;
    }
}

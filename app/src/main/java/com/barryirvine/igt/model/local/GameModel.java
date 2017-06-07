package com.barryirvine.igt.model.local;

public class GameModel {

    private String mName;
    private String mJackpot;
    private String mDate;

    public GameModel(final Builder builder) {
        mName = builder.mName;
        mJackpot = builder.mJackpot;
        mDate = builder.mDate;
    }

    public String getName() {
        return mName;
    }

    public String getJackpot() {
        return mJackpot;
    }

    public String getDate() {
        return mDate;
    }

    public static class Builder {
        private String mName;
        private String mJackpot;
        private String mDate;

        public Builder name(final String name) {
            mName = name;
            return this;
        }

        public Builder jackpot(final String jackpot) {
            mJackpot = jackpot;
            return this;
        }

        public Builder date(final String date) {
            mDate = date;
            return this;
        }

        public GameModel build() {
            return new GameModel(this);
        }

    }
}

package com.barryirvine.igt.model.mapper;


import com.barryirvine.igt.model.local.GameModel;
import com.barryirvine.igt.model.server.Game;
import com.barryirvine.igt.model.server.GameData;
import com.barryirvine.igt.utils.CurrencyUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class GameResponseMapper {

    /**
     * Returns the date appropriate to the timezone and format
     *
     * @param date             The UTC date to be formatted
     * @param locale           The locale it's to be formatted into
     * @param dateFormatString The format string
     * @param timeZone         The timezone that the date should be shown local to
     * @return The date in correct format and for the supplied time zone
     */
    private static String getTZDate(final Date date, final Locale locale, final String dateFormatString, final TimeZone timeZone) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatString, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);

    }

    public List<GameModel> map(final GameData gameData, final Locale locale, final String dateFormatString, final TimeZone timeZone) {
        if (gameData == null || gameData.getData() == null || gameData.getData().size() == 0 || gameData.getCurrency() == null) {
            return null;
        }

        final List<GameModel> games = new ArrayList<>(gameData.getData().size());
        final Currency currency = Currency.getInstance(gameData.getCurrency());
        for (final Game game : gameData.getData()) {
            games.add(
                    new GameModel.Builder()
                            .name(game.getName())
                            .jackpot(CurrencyUtils.getAmountString(currency, locale, game.getJackpot()))
                            .date(getTZDate(game.getDate(), locale, dateFormatString, timeZone))
                            .build());
        }

        return games;
    }
}

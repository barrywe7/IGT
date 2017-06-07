package com.barryirvine.igt.utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyUtils {

    /**
     * @param currency Currency that will be displayed
     * @param locale   Locale that you want the currency to be displayed in
     * @param amount   Amount (assumed to be in cents/pennies) that should be adapted to a currency amount
     * @return Formatted string with correct currency symbol and symbols for the Locale
     */
    public static String getAmountString(final Currency currency, final Locale locale, final int amount) {
        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        return numberFormat.format(amount / 100);
    }
}

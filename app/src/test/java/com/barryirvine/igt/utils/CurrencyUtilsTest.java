package com.barryirvine.igt.utils;

import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class CurrencyUtilsTest {
    @Test
    public void testGetJackpotString() throws Exception {
        // Check that 1000 is shown as $10.00 in the USA
        assertEquals("$10.00", CurrencyUtils.getAmountString(Currency.getInstance(Locale.US), Locale.US, 1000));
        // In Canada it's the same but you need to be specific with the country of the dollar
        assertEquals("US$10.00", CurrencyUtils.getAmountString(Currency.getInstance(Locale.US), Locale.CANADA, 1000));
        // But Canadian dollars are fine
        assertEquals("$10.00", CurrencyUtils.getAmountString(Currency.getInstance(Locale.CANADA), Locale.CANADA, 1000));
        // But when in the US, again we need to know the country of the dollars
        assertEquals("CAD10.00", CurrencyUtils.getAmountString(Currency.getInstance(Locale.CANADA), Locale.US, 1000));
        // Now Italian, we have a space and the comma is the separator
        assertEquals("USD 10,00", CurrencyUtils.getAmountString(Currency.getInstance(Locale.US), Locale.ITALY, 1000));
        // And in French, comma but currency at the end
        assertEquals("10,00 USD", CurrencyUtils.getAmountString(Currency.getInstance(Locale.US), Locale.FRANCE, 1000));
        // Similarly for the local currencies
        assertEquals("10,00 €", CurrencyUtils.getAmountString(Currency.getInstance(Locale.FRANCE), Locale.FRANCE, 1000));
        assertEquals("€ 10,00", CurrencyUtils.getAmountString(Currency.getInstance(Locale.FRANCE), Locale.ITALY, 1000));
    }
}

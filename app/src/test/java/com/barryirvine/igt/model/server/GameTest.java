package com.barryirvine.igt.model.server;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;

import org.junit.Test;

import java.text.ParsePosition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    private static final String GAME_NAME = "Game 1";
    private static final int JACKPOT = 34000000;
    private static final String DATE = "2015-01-25T20:20:30+01:00";

    private static final String SINGLE_GAME_JSON = "{\n" +
            "\"name\": \"" + GAME_NAME + "\",\n" +
            "\"jackpot\": " + JACKPOT + ",\n" +
            "\"date\": \"" + DATE + "\"\n}";

    @Test
    public void testResponseParsedToModel() throws Exception {
        final Game game = new Gson().fromJson(SINGLE_GAME_JSON, Game.class);
        assertNotNull("Game should not be null", game);
        assertEquals(JACKPOT, game.getJackpot());
        assertEquals(GAME_NAME, game.getName());
        assertEquals(ISO8601Utils.parse(DATE, new ParsePosition(0)), game.getDate());
    }
}

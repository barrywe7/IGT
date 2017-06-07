package com.barryirvine.igt.model.mapper;

import android.content.Context;

import com.barryirvine.igt.model.local.GameModel;
import com.barryirvine.igt.model.server.Game;
import com.barryirvine.igt.model.server.GameData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GameResponseMapperTest {

    private GameResponseMapper mTestable = new GameResponseMapper();

    @Mock
    private GameData mGameData;
    @Mock
    private Context mContext;
    @Mock
    private Game mGame;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mGame.getName()).thenReturn("Game");
        when(mGame.getDate()).thenReturn(new Date(1495810000000L)); //26 May 2017 2:46:40PM GMT
        when(mGame.getJackpot()).thenReturn(10000);
        when(mGameData.getData()).thenReturn(Collections.singletonList(mGame));

    }


    @Test
    public void testMapper() throws Exception {
        when(mGameData.getCurrency()).thenReturn("USD");
        // NB The format used for the date and time and the timezone is injected in so that it's
        // appropriate to the device locale and location and 24 hour preferences
        final List<GameModel> result = mTestable.map(mGameData, Locale.CANADA, "MM/dd/yyyy HH:mm",
                TimeZone.getTimeZone("PST"));
        final GameModel gameModel = result.get(0);
        assertEquals("Game", gameModel.getName());
        assertEquals("US$100.00", gameModel.getJackpot());
        assertEquals("05/26/2017 07:46", gameModel.getDate()); // -8 hours from original date
        //TODO:
    }

    @Test
    public void testMapper12HourClock() throws Exception {
        when(mGameData.getCurrency()).thenReturn("USD");
        // NB The format used for the date and time and the timezone is injected in so that it's
        // appropriate to the device locale and location and 24 hour preferences
        final List<GameModel> result = mTestable.map(mGameData, Locale.CANADA, "MM/dd/yyyy hh:mm a",
                TimeZone.getTimeZone("PST"));
        final GameModel gameModel = result.get(0);
        assertEquals("Game", gameModel.getName());
        assertEquals("US$100.00", gameModel.getJackpot());
        assertEquals("05/26/2017 07:46 AM", gameModel.getDate()); // -8 hours from original date
        //TODO:
    }

}

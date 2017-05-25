package com.barryirvine.igt.model.server;

import com.barryirvine.igt.TestUtils;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The purpose of this test is not to test the Gson deserialisation but to ensure that
 * the data model is configured correctly
 */
public class GameDataTest {

    @Test
    public void testResponseParsedToModel() throws Exception {
        final String json = TestUtils.getFileContents("gameData.json", GameDataTest.class);
        final GameData response = new Gson().fromJson(json, GameData.class);
        assertNotNull("Response should not be null", response);
        assertEquals(8, response.getData().size());
        assertEquals("GBP", response.getCurrency());
    }
}

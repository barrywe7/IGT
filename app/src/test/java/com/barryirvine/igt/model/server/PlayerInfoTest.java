package com.barryirvine.igt.model.server;

import com.barryirvine.igt.TestUtils;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerInfoTest {

    @Test
    public void testResponseParsedToModel() throws Exception {
        final String json = TestUtils.getFileContents("playerInfo.json", PlayerInfoTest.class);
        final PlayerInfo response = new Gson().fromJson(json, PlayerInfo.class);
        assertNotNull("Response should not be null", response);
        assertEquals("PlayerName", response.getName());
        assertEquals(987654, response.getBalance());
        assertEquals("https://dl.dropboxusercontent.com/s/8a1j70z1ik3y0q8/user_avatar.png", response.getAvatarLink());
        assertEquals("04/05/2016T16:45", response.getLastLoginDate());
    }
}

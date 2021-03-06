package com.barryirvine.igt.ui.activity;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testActivityCreated() throws Exception {
        final MainActivity activity = mMainActivityActivityTestRule.getActivity();
        assertNotNull(activity.mBinding);
        assertNotNull(activity.getSupportActionBar());
    }

}
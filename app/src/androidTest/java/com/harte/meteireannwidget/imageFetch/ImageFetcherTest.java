package com.harte.meteireannwidget.imageFetch;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ImageFetcherTest {

    @Test
    public void fetchWeatherSymbol() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        ImageFetcher fetcher = new ImageFetcher(appContext);
        assertNotEquals(fetcher.fetchWeatherSymbol("01d"), 0);
    }

    @Test(expected = ImageNotFoundException.class)
    public void fetchWeatherSymbolException() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        ImageFetcher fetcher = new ImageFetcher(appContext);
        fetcher.fetchWeatherSymbol("garbageFilename");
    }
}
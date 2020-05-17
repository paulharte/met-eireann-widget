package com.harte.meteireannwidget.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.harte.meteireannwidget.met.County;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4::class)
public class CountyFinderTest {

    @Test
    public void find() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        CountyFinder finder = new CountyFinder(Locale.ENGLISH, appContext);

        Location loc = new Location(LocationManager.NETWORK_PROVIDER);
        loc.setLongitude(52.6477);
        loc.setLatitude(-7.2561);

        assertEquals(County.Kilkenny, finder.findCounty(loc));
    }

}
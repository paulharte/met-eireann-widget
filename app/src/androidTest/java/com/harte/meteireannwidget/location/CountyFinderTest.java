package com.harte.meteireannwidget.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.harte.meteireannwidget.met.County;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class CountyFinderTest {
    @Test
    public void findKilkenny() throws Exception {
        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        CountyFinder finder = new CountyFinder(Locale.ENGLISH, appContext);

        Location loc = new Location(LocationManager.NETWORK_PROVIDER);

        // Kilkenny 52.6477, 7.2561
        loc.setLatitude(52.6477);
        loc.setLongitude(-7.2561);

        assertEquals(County.Kilkenny, finder.findCounty(loc));
    }

    @Test
    public void findDublin() throws Exception {
        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        CountyFinder finder = new CountyFinder(Locale.ENGLISH, appContext);

        Location loc = new Location(LocationManager.NETWORK_PROVIDER);

        // Clontarf/Killester 53.3750131,-6.182147,14z
        loc.setLatitude(53.3750131);
        loc.setLongitude(-6.182147);

        assertEquals(County.Dublin, finder.findCounty(loc));
    }

}
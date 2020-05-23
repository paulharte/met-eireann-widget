package com.harte.meteireannwidget.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;

import com.harte.meteireannwidget.met.County;
import com.harte.meteireannwidget.met.OutsideForecastException;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CountyFinder {

    private static final String TAG = "CountyFinder";
    Geocoder geoCoder;

    public CountyFinder(@NonNull Locale locale, @NonNull Context context) {
        this.geoCoder = new Geocoder(context, locale);
    }

    public County findCounty(Location location) throws IOException, OutsideForecastException {
        if (location == null) {
            throw new OutsideForecastException();
        }
        List<Address> addresses = geoCoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        for (Address address : addresses) {
            if (address.getAdminArea() != null) {
                Log.d(TAG, "admin area " + address.getAdminArea());
                String county = address.getAdminArea().replace("County ", "");

                for (County irishCounty : County.values()) {
                    Log.v(TAG, "irishcounty " + irishCounty.toString());
                    if (irishCounty.toString().toUpperCase().equals( county.toUpperCase()) ) {
                        return irishCounty;
                    }
                }
            }
        }
        throw new OutsideForecastException();
    }
}

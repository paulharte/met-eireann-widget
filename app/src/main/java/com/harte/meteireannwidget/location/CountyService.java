package com.harte.meteireannwidget.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;

import androidx.core.app.ActivityCompat;

import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Tasks;
import com.harte.meteireannwidget.met.County;
import com.harte.meteireannwidget.met.OutsideForecastException;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static android.content.Context.LOCATION_SERVICE;

public class CountyService {

    private static final String TAG = "CountyService";
    private County currentCounty;
    private FusedLocationProviderClient fusedLocationClient;
    private CountyFinder countyFinder;
    private Context context;

    public CountyService(@NonNull Context context) {
        this.context = context;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context);
    }

    public County determineCurrentCounty() {
        Log.i(TAG, "Getting county");
        this.countyFinder = new CountyFinder(Locale.ENGLISH, this.context);
        Location location = this.getLocation();
        this.currentCounty = this.retrieveCounty(location);
        return this.currentCounty;
    }

    private Location getLocation() {
        // Get the location manager
        LocationManager locationManager = (LocationManager) this.context.getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //TODO: probably change this to an exception, with a display message
            Log.e(TAG, "Cannot get location, user has not granted access");
            return null;
        }
        return locationManager.getLastKnownLocation(bestProvider);

    }

    private County getCurrentCounty(){
        return this.currentCounty;
    }

    private County retrieveCounty(Location location) {
        try {
            return this.countyFinder.findCounty(location);
        } catch (IOException | OutsideForecastException ex) {
            Log.i(TAG, "Could not determine location due to ", ex);
            return null;
        }
    }

    public void onLocationChanged(Location location) {
        County newCounty = this.retrieveCounty(location);
        if (!newCounty.equals(this.currentCounty)) {
            this.currentCounty = newCounty;
            //Publish
        }
    }
}

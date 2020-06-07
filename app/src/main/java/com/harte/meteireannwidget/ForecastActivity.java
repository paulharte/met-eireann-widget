package com.harte.meteireannwidget;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.harte.meteireannwidget.permissions.RequestPermissions;

public class ForecastActivity extends AppCompatActivity {
    private static final String TAG = "AppCompatActivity";

    private static ForecastComponent component;

    public void onCreate(Bundle savedInstanceState) {

        //TODO: in future do this all in the WeatherWidget class, as appropriate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        RequestPermissions.requestPermissions(getApplicationContext(), this);
        component = DaggerForecastComponent.builder()
                .forecastModule(new ForecastModule(getApplicationContext()))
                .build();
    }

    public static ForecastComponent getForecastComponent() {
        return component;
    }

    public void onClickUpdate(View view) {

        Log.i(TAG, "update button clicked");
    }
}

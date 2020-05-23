package com.harte.meteireannwidget;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.harte.meteireannwidget.permissions.RequestPermissions;

public class ForecastActivity extends AppCompatActivity {
    private static final String TAG = "AppCompatActivity";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        RequestPermissions.requestPermissions(getApplicationContext(), this);
    }

    public void onClickUpdate(View view) {

        Log.i(TAG, "update button clicked");
    }
}
